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
import com.sun.xml.rpc.encoding.literal.DetailFragmentDeserializer;
import com.sun.xml.rpc.encoding.simpletype.*;
import com.sun.xml.rpc.encoding.soap.SOAPConstants;
import com.sun.xml.rpc.encoding.soap.SOAP12Constants;
import com.sun.xml.rpc.streaming.*;
import com.sun.xml.rpc.wsdl.document.schema.SchemaConstants;
import javax.xml.namespace.QName;

public class OpenInterfaceIF_importPricelist_ResponseStruct_SOAPSerializer extends ObjectSerializerBase implements Initializable {
    private static final QName ns1_result_QNAME = new QName("", "result");
    private static final QName ns2_ImportResult_TYPE_QNAME = new QName("http://www.smilehouse.com/types", "ImportResult");
    private CombinedSerializer ns2_myImportResult_SOAPSerializer;
    private static final int myRESULT_INDEX = 0;
    
    public OpenInterfaceIF_importPricelist_ResponseStruct_SOAPSerializer(QName type, boolean encodeType, boolean isNullable, String encodingStyle) {
        super(type, encodeType, isNullable, encodingStyle);
    }
    
    public void initialize(InternalTypeMappingRegistry registry) throws Exception {
        ns2_myImportResult_SOAPSerializer = (CombinedSerializer)registry.getSerializer(SOAPConstants.NS_SOAP_ENCODING, smilehouse.openinterface.ImportResult.class, ns2_ImportResult_TYPE_QNAME);
    }
    
    public Object doDeserialize(SOAPDeserializationState state, XMLReader reader,
        SOAPDeserializationContext context) throws Exception {
        smilehouse.openinterface.OpenInterfaceIF_importPricelist_ResponseStruct instance = new smilehouse.openinterface.OpenInterfaceIF_importPricelist_ResponseStruct();
        smilehouse.openinterface.OpenInterfaceIF_importPricelist_ResponseStruct_SOAPBuilder builder = null;
        Object member;
        boolean isComplete = true;
        QName elementName;
        
        reader.nextElementContent();
        if (reader.getState() == XMLReader.START) {
            member = ns2_myImportResult_SOAPSerializer.deserialize(null, reader, context);
            if (member instanceof SOAPDeserializationState) {
                if (builder == null) {
                    builder = new smilehouse.openinterface.OpenInterfaceIF_importPricelist_ResponseStruct_SOAPBuilder();
                }
                state = registerWithMemberState(instance, state, member, myRESULT_INDEX, builder);
                isComplete = false;
            } else {
                instance.setResult((smilehouse.openinterface.ImportResult)member);
            }
            reader.nextElementContent();
        }
        elementName = reader.getName();
        
        XMLReaderUtil.verifyReaderState(reader, XMLReader.END);
        return (isComplete ? (Object)instance : (Object)state);
    }
    
    public void doSerializeAttributes(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        smilehouse.openinterface.OpenInterfaceIF_importPricelist_ResponseStruct instance = (smilehouse.openinterface.OpenInterfaceIF_importPricelist_ResponseStruct)obj;
        
    }
    
    public void doSerializeInstance(Object obj, XMLWriter writer, SOAPSerializationContext context) throws Exception {
        smilehouse.openinterface.OpenInterfaceIF_importPricelist_ResponseStruct instance = (smilehouse.openinterface.OpenInterfaceIF_importPricelist_ResponseStruct)obj;
        
        ns2_myImportResult_SOAPSerializer.serialize(instance.getResult(), ns1_result_QNAME, null, writer, context);
    }
    protected void verifyName(XMLReader reader, QName expectedName) throws Exception {
    }
}
