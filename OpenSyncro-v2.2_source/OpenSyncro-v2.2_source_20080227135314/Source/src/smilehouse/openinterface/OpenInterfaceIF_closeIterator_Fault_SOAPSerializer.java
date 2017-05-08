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

// This class was generated by the JAXRPC SI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Standard Implementation (1.1, build R59)

package smilehouse.openinterface;


import com.sun.xml.rpc.encoding.*;
import com.sun.xml.rpc.encoding.soap.SOAPConstants;
import com.sun.xml.rpc.encoding.soap.SOAP12Constants;
import com.sun.xml.rpc.soap.message.SOAPFaultInfo;
import com.sun.xml.rpc.streaming.*;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;
import javax.xml.namespace.QName;

public class OpenInterfaceIF_closeIterator_Fault_SOAPSerializer extends SOAPFaultInfoSerializer {
    private static final QName ns1_OpenInterfaceException_QNAME = new QName("http://www.smilehouse.com/wsdl", "OpenInterfaceException");
    private static final QName ns2_OpenInterfaceException_TYPE_QNAME = new QName("http://www.smilehouse.com/types", "OpenInterfaceException");
    private CombinedSerializer ns2_myOpenInterfaceException_InterfaceSOAPSerializer;
    private CombinedSerializer ns2_myOpenInterfaceException_InterfaceSOAPSerializer_Serializer;
    private static final QName ns1_AccessDeniedException_QNAME = new QName("http://www.smilehouse.com/wsdl", "AccessDeniedException");
    private static final QName ns2_AccessDeniedException_TYPE_QNAME = new QName("http://www.smilehouse.com/types", "AccessDeniedException");
    private CombinedSerializer ns2_myAccessDeniedException_SOAPSerializer;
    private CombinedSerializer ns2_myAccessDeniedException_SOAPSerializer_Serializer;
    private static final int SMILEHOUSE_OPENINTERFACE_OPENINTERFACEEXCEPTION_INDEX = 0;
    private static final int SMILEHOUSE_OPENINTERFACE_ACCESSDENIEDEXCEPTION_INDEX = 1;
    
    public OpenInterfaceIF_closeIterator_Fault_SOAPSerializer(boolean encodeType, boolean isNullable) {
        super(encodeType, isNullable);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws Exception {
        super.initialize(registry);
        ns2_myOpenInterfaceException_InterfaceSOAPSerializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, smilehouse.openinterface.OpenInterfaceException.class, ns2_OpenInterfaceException_TYPE_QNAME);
        ns2_myOpenInterfaceException_InterfaceSOAPSerializer_Serializer = ns2_myOpenInterfaceException_InterfaceSOAPSerializer.getInnermostSerializer();
        ns2_myAccessDeniedException_SOAPSerializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, smilehouse.openinterface.AccessDeniedException.class, ns2_AccessDeniedException_TYPE_QNAME);
        ns2_myAccessDeniedException_SOAPSerializer_Serializer = ns2_myAccessDeniedException_SOAPSerializer.getInnermostSerializer();
    }
    
    protected Object deserializeDetail(SOAPDeserializationState state, XMLReader reader,
        SOAPDeserializationContext context, SOAPFaultInfo instance) throws Exception {
        boolean isComplete = true;
        QName elementName;
        QName elementType = null;
        SOAPInstanceBuilder builder = null;
        Object detail = null;
        Object obj = null;
        
        reader.nextElementContent();
        if (reader.getState() == XMLReader.END)
            return deserializeDetail(reader, context);
        XMLReaderUtil.verifyReaderState(reader, XMLReader.START);
        elementName = reader.getName();
        elementType = getType(reader);
        if (elementName.equals(ns1_AccessDeniedException_QNAME)) {
            if (elementType == null || 
                (elementType.equals(ns2_myAccessDeniedException_SOAPSerializer.getXmlType()) ||
                (ns2_myAccessDeniedException_SOAPSerializer_Serializer instanceof ArraySerializerBase &&
                elementType.equals(SOAPConstants.QNAME_ENCODING_ARRAY)) ) ) {
                obj = ns2_myAccessDeniedException_SOAPSerializer.deserialize(ns1_AccessDeniedException_QNAME, reader, context);
                if (obj instanceof SOAPDeserializationState) {
                    builder = new smilehouse.openinterface.OpenInterfaceIF_closeIterator_Fault_SOAPBuilder();
                    state = registerWithMemberState(instance, state, obj,
                        SMILEHOUSE_OPENINTERFACE_ACCESSDENIEDEXCEPTION_INDEX, builder);
                    isComplete = false;
                } else {
                    detail = obj;
                }
                reader.nextElementContent();
                skipRemainingDetailEntries(reader);
                XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
                return (isComplete ? (Object)detail : (Object)state);
            } 
        } else if (elementName.equals(ns1_OpenInterfaceException_QNAME)) {
            obj = ns2_myOpenInterfaceException_InterfaceSOAPSerializer.deserialize(ns1_OpenInterfaceException_QNAME, reader, context);
            if (obj instanceof SOAPDeserializationState) {
                builder = new smilehouse.openinterface.OpenInterfaceIF_closeIterator_Fault_SOAPBuilder();
                state = registerWithMemberState(instance, state, obj,
                    SMILEHOUSE_OPENINTERFACE_OPENINTERFACEEXCEPTION_INDEX, builder);
                isComplete = false;
            } else {
                detail = obj;
            }
            reader.nextElementContent();
            skipRemainingDetailEntries(reader);
            XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
            return (isComplete ? (Object)detail : (Object)state);
            
        }
        return deserializeDetail(reader, context);
    }
    
    protected void serializeDetail(Object detail, XMLWriter writer, SOAPSerializationContext context)
        throws Exception {
        if (detail == null) {
            throw new SerializationException("soap.unexpectedNull");
        }
        writer.startElement(DETAIL_QNAME);
        
        boolean pushedEncodingStyle = false;
        if (encodingStyle != null) {
            context.pushEncodingStyle(encodingStyle, writer);
        }
        if (detail instanceof smilehouse.openinterface.AccessDeniedException) {
            ns2_myAccessDeniedException_SOAPSerializer_Serializer.serialize(detail, ns1_AccessDeniedException_QNAME, null, writer, context);
        }
        else if (detail instanceof smilehouse.openinterface.OpenInterfaceException) {
            ns2_myOpenInterfaceException_InterfaceSOAPSerializer_Serializer.serialize(detail, ns1_OpenInterfaceException_QNAME, null, writer, context);
        }
        writer.endElement();
        if (pushedEncodingStyle) {
            context.popEncodingStyle();
        }
    }
}
