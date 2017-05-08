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
import com.sun.xml.rpc.soap.message.SOAPFaultInfo;
import java.lang.IllegalArgumentException;

public final class OpenInterfaceIF_iterate_Fault_SOAPBuilder implements SOAPInstanceBuilder {
    private SOAPFaultInfo instance = null;
    private Object detail;
    // this is the index of the fault deserialized
    private int index = -1;
    private static final int SMILEHOUSE_OPENINTERFACE_OPENINTERFACEEXCEPTION_INDEX = 0;
    private static final int SMILEHOUSE_OPENINTERFACE_ACCESSDENIEDEXCEPTION_INDEX = 1;
    private static final int SMILEHOUSE_OPENINTERFACE_ITERATORCLOSEDEXCEPTION_INDEX = 2;
    
    public int memberGateType(int memberIndex) {
        return GATES_INITIALIZATION + REQUIRES_COMPLETION;
    }
    
    public void construct() {
    }
    
    public void setMember(int index, Object memberValue) {
        this.index = index;
        detail = memberValue;
    }
    
    public void initialize() {
        switch (index) {
            case SMILEHOUSE_OPENINTERFACE_OPENINTERFACEEXCEPTION_INDEX:
                instance.setDetail(detail);
                break;
            case SMILEHOUSE_OPENINTERFACE_ACCESSDENIEDEXCEPTION_INDEX:
                instance.setDetail(detail);
                break;
            case SMILEHOUSE_OPENINTERFACE_ITERATORCLOSEDEXCEPTION_INDEX:
                instance.setDetail(detail);
                break;
        }
    }
    
    public void setInstance(Object instance) {
        this.instance = (SOAPFaultInfo)instance;
    }
    
    public Object getInstance() {
        return instance;
    }
}
