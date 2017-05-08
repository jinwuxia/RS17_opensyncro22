/* OpenSyncro - A web-based enterprise application integration tool
 * Copyright (C) 2008 Smilehouse Oy, support@opensyncro.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

/*
 * Created on 24.11.2004
 */
package smilehouse.opensyncro.defaultcomponents.workspace;

import java.rmi.RemoteException;
import java.util.Locale;

import smilehouse.gui.html.fieldbased.FieldInfo;
import smilehouse.gui.html.fieldbased.GUIContext;
import smilehouse.gui.html.fieldbased.editor.BooleanEditor;
import smilehouse.gui.html.fieldbased.editor.DefaultSelectOption;
import smilehouse.gui.html.fieldbased.editor.PasswordEditor;
import smilehouse.gui.html.fieldbased.editor.SelectEditor;
import smilehouse.gui.html.fieldbased.formatter.IntegerFormatter;
import smilehouse.gui.html.fieldbased.model.DefaultModelModifier;
import smilehouse.gui.html.fieldbased.model.ModelModifier;
import smilehouse.openinterface.AccessDeniedException;
import smilehouse.openinterface.ImportResult;
import smilehouse.openinterface.LoginInfo;
import smilehouse.openinterface.OpenInterfaceException;
import smilehouse.openinterface.OpenInterfaceIF;
import smilehouse.opensyncro.pipes.component.AbortTransferException;
import smilehouse.opensyncro.pipes.component.DestinationIF;
import smilehouse.opensyncro.pipes.component.FailTransferException;
import smilehouse.opensyncro.pipes.component.PipeComponentData;
import smilehouse.opensyncro.pipes.component.PipeComponentUtils;
import smilehouse.opensyncro.pipes.gui.GUIConfigurationIF;
import smilehouse.opensyncro.pipes.gui.GUIDefinition;
import smilehouse.opensyncro.pipes.log.MessageLogger;
import smilehouse.opensyncro.pipes.metadata.DestinationInfo;
import smilehouse.opensyncro.system.Environment;

/**
 * Feeds customer XML to Workspace though OpenInterface API.
 */
public class RemoteCustomerDestination implements DestinationIF, GUIConfigurationIF {

    // ------------------------
    // Constants for attributes
    // ------------------------
    private static final String HOST_ATTR = "host";
    private static final String DATABASE_ATTR = "database";
    private static final String USER_ATTR = "user";
    private static final String PASSWORD_ATTR = "password";
    private static final String IMPORT_MODE_ATTR = "import_mode";
    private static final String CREATE_GROUPS_ATTR = "create_groups";

    private static final String[] IMPORT_MODE_LABELS = {
            "insert_or_update",
            "insert",
            "update",
            "insert_as_new",
            "total_replace"};


    private static GUIDefinition gui = new CustomerDestinationGUI();

    private static class CustomerDestinationGUI extends GUIDefinition {

        public CustomerDestinationGUI() {
            try {
                // Host
                addSimpleTextFieldForComponent(HOST_ATTR, HOST_ATTR, 40);
                // Database
                addSimpleTextFieldForComponent(DATABASE_ATTR, DATABASE_ATTR, 20);
                // USer
                addSimpleTextFieldForComponent(USER_ATTR, USER_ATTR, 20);
                // Password
                {
                    ModelModifier modifier = new DefaultModelModifier() {
                        public Object getModelValue(Object model) throws Exception {
                            return "";
                        }

                        public void setModelValue(Object model, Object value) throws Exception {
                            String valueStr = (String) value;
                            if(valueStr != null && valueStr.length() > 0)
                                ((DestinationIF) model).getData().setAttribute(PASSWORD_ATTR, valueStr);
                        }
                    };

                    PasswordEditor editor = new PasswordEditor();
                    editor.setSize(10);

                    FieldInfo fieldInfo = new FieldInfo(
                        PASSWORD_ATTR,
                        PASSWORD_ATTR,
                        modifier,
                        editor);

                    //add the configuration to the context for usage in the http-requests.
                    addField(PASSWORD_ATTR, fieldInfo);
                }
                // Import type
                {
                    ModelModifier modifier = new DefaultModelModifier() {
                        public Object getModelValue(Object model) throws Exception {
                            Integer value = ((DestinationIF) model)
                                .getData().getIntegerAttribute(IMPORT_MODE_ATTR);
                            return value != null ? value : new Integer(0);
                        }

                        public void setModelValue(Object model, Object value) throws Exception {
                            int intValue = value != null ? ((Integer) value).intValue() : 0;
                            ((DestinationIF) model).getData().setAttribute(IMPORT_MODE_ATTR, intValue);
                        }
                    };

                    SelectEditor editor = new SelectEditor();
                    for(int i = 0; i < IMPORT_MODE_LABELS.length; i++)
                        editor.addOption(new DefaultSelectOption(
                            new Integer(i),
                            IMPORT_MODE_LABELS[i]));

                    editor.setFormatter(new IntegerFormatter());

                    //and finally create the configurationObject
                    FieldInfo fieldInfo = new FieldInfo(
                        IMPORT_MODE_ATTR,
                        IMPORT_MODE_ATTR,
                        modifier,
                        editor);

                    //add the configuration to the context for usage in the http-requests.
                    addField(IMPORT_MODE_ATTR, fieldInfo);
                }
                // Create customer groups
                {
                    ModelModifier modifier = new DefaultModelModifier() {
                        public Object getModelValue(Object model) throws Exception {
                            Boolean value = ((DestinationIF) model)
                                .getData().getBooleanAttribute(CREATE_GROUPS_ATTR);
                            if(value == null)
                                value = Boolean.FALSE;
                            return value;
                        }

                        public void setModelValue(Object model, Object value) throws Exception {
                            boolean booleanValue = value != null ? ((Boolean) value).booleanValue()
                                    : false;
                            ((DestinationIF) model).getData().setAttribute(CREATE_GROUPS_ATTR, booleanValue);
                        }
                    };

                    BooleanEditor editor = new BooleanEditor();

                    FieldInfo fieldInfo = new FieldInfo(
                        CREATE_GROUPS_ATTR,
                        CREATE_GROUPS_ATTR,
                        modifier,
                        editor);

                    //add the configuration to the context for usage in the http-requests.
                    addField(CREATE_GROUPS_ATTR, fieldInfo);
                }
            } catch(Exception e) {
                Environment.getInstance().log(
                    "Could not create GUI for RemoteCustomerDestination",
                    e);
            }
        }
    }

    public GUIContext getGUIContext() {
        return gui.getGUIContext();
    }

    public String getGUITemplate() {
        return "<table border=\"0\">" + "<tr><td>$" + HOST_ATTR + "$</td><td>$" + DATABASE_ATTR
                + "$</td></tr>" + "<tr><td>$" + USER_ATTR + "$</td><td>$" + PASSWORD_ATTR
                + "$</td></tr>" + "<tr><td colspan=\"2\"><hr></td></tr>" + "<tr><td>$"
                + IMPORT_MODE_ATTR + "$</td><td>$" + CREATE_GROUPS_ATTR + "$</td></tr>"
                + "</table>";

    }

    public RemoteCustomerDestination( Object pipeComponentData ) {
        setData((PipeComponentData) pipeComponentData);
    }
    
    protected PipeComponentData data;
    
    public void setData(PipeComponentData data) {
        this.data = data;
    }

    public PipeComponentData getData() {
        return data;
    }
    
    public final int getType() {
        return TYPE_DESTINATION;
    }
    
    public String getName() {
        return "RemoteCustomerDestination";
    }

    public String getID() {
        return "smilehouse.opensyncro.defaultcomponents.workspace.RemoteCustomerDestination";
    }

    public String getDescription(Locale locale) {
        return PipeComponentUtils.getDescription(locale, this.getClass());
    }
    
    // Dummy methods due to no iteration supported
    public int open(DestinationInfo info, MessageLogger logger) throws FailTransferException {
        return ITERATION_OPEN_STATUS_OK;
    }

    public int close(DestinationInfo info, MessageLogger logger) throws FailTransferException {
        return ITERATION_CLOSE_STATUS_OK;
    }

    public void lastBlockStatus(int statusCode) { }

    /**
     * The method actually called by pipe during the conversion. This default implementation uses
     * the take-method to handle all the input records separately, So in most cases you only need to
     * implement it. If however you for some reason need access to all the data you can overwrite
     * this.
     */
    public void takeAll(String[] data, DestinationInfo info, MessageLogger logger) throws FailTransferException,
    																					  AbortTransferException {
        for(int i = 0; i < data.length; i++) {
            take(data[i], info, logger);
        }
    }
    
    public void take(String data, DestinationInfo info, MessageLogger logger) throws FailTransferException,
    																				 AbortTransferException {
        // --------------------------------
        // Check that the attributes are OK
        // --------------------------------
        String host = this.data.getAttribute(HOST_ATTR);
        if(host == null || host.length() == 0) {
            logger.logMessage("Host not set", this, MessageLogger.ERROR);
            PipeComponentUtils.failTransfer();
        }

        String database = this.data.getAttribute(DATABASE_ATTR);
        if(database == null || database.length() == 0) {
            logger.logMessage("Database not set", this, MessageLogger.ERROR);
            PipeComponentUtils.failTransfer();
        }

        String user = this.data.getAttribute(USER_ATTR);
        if(user == null || user.length() == 0) {
            logger.logMessage("User not set", this, MessageLogger.ERROR);
            PipeComponentUtils.failTransfer();
        }

        String password = this.data.getAttribute(PASSWORD_ATTR);
        if(password == null || password.length() == 0) {
            logger.logMessage("Password not set", this, MessageLogger.ERROR);
            PipeComponentUtils.failTransfer();
        }

        Integer importMode = this.data.getIntegerAttribute(IMPORT_MODE_ATTR);
        if(importMode == null) {
            logger.logMessage("Import mode not set", this, MessageLogger.ERROR);
            PipeComponentUtils.failTransfer();
        }

        Boolean createGroupsO = this.data.getBooleanAttribute(CREATE_GROUPS_ATTR);
        boolean createGroups = createGroupsO != null ? createGroupsO.booleanValue() : false;

        // ----------------------------
        // Connect to the OpenInterface
        // ----------------------------
        String oiEndpointAddress = WorkspaceOIUtils.getOIEndpointAddress(database, host, logger, this);
        OpenInterfaceIF oi = WorkspaceOIUtils.getOpenInterfaceIF(oiEndpointAddress, host);

        // -------------
        // Do the import
        // -------------
        try {
            LoginInfo login = new LoginInfo();
            login.setDatabase(database);
            login.setUserName(user);
            login.setPassword(password);
            ImportResult result = oi.importCustomers(
                login,
                data,
                importMode.intValue(),
                createGroups);
            WorkspaceOIUtils.logImportResult(result, logger, this, true);
        } catch(AccessDeniedException ade) {
            logger.logMessage(
                "Access to OpenInterface was denied. Check your username and password settings.",
                this,
                MessageLogger.ERROR);
            PipeComponentUtils.failTransfer();
        } catch(RemoteException re) {
            logger.logMessage(
                "Couldn't access the remote OpenInterface: " + re.getMessage(),
                this,
                MessageLogger.ERROR);
            Environment.getInstance().log("Couldn't access the remote OpenInterface", re);
            PipeComponentUtils.failTransfer();
        } catch(OpenInterfaceException oie) {
            logger.logMessage(
                "OpenInterfaceException while importing customers: " + oie.getMessage(),
                this,
                MessageLogger.ERROR);
            Environment.getInstance().log("OpenInterfaceException while importing customers", oie);
            PipeComponentUtils.failTransfer();
        }
    }
}