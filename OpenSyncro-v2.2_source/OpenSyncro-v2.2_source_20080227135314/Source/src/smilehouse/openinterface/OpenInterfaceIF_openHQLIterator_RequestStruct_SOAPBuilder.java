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
import com.sun.xml.rpc.util.exception.LocalizableExceptionAdapter;

public class OpenInterfaceIF_openHQLIterator_RequestStruct_SOAPBuilder implements SOAPInstanceBuilder {
    private smilehouse.openinterface.OpenInterfaceIF_openHQLIterator_RequestStruct _instance;
    private smilehouse.openinterface.LoginInfo loginInfo_1;
    private java.lang.String string_2;
    private long long_3;
    private static final int myLOGININFO_1_INDEX = 0;
    private static final int mySTRING_2_INDEX = 1;
    private static final int myLONG_3_INDEX = 2;
    
    public OpenInterfaceIF_openHQLIterator_RequestStruct_SOAPBuilder() {
    }
    
    public void setLoginInfo_1(smilehouse.openinterface.LoginInfo loginInfo_1) {
        this.loginInfo_1 = loginInfo_1;
    }
    
    public void setString_2(java.lang.String string_2) {
        this.string_2 = string_2;
    }
    
    public void setLong_3(long long_3) {
        this.long_3 = long_3;
    }
    
    public int memberGateType(int memberIndex) {
        switch (memberIndex) {
            case myLOGININFO_1_INDEX:
                return GATES_INITIALIZATION | REQUIRES_CREATION;
            case mySTRING_2_INDEX:
                return GATES_INITIALIZATION | REQUIRES_CREATION;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public void construct() {
    }
    
    public void setMember(int index, Object memberValue) {
        try {
            switch(index) {
                case myLOGININFO_1_INDEX:
                    _instance.setLoginInfo_1((smilehouse.openinterface.LoginInfo)memberValue);
                    break;
                case mySTRING_2_INDEX:
                    _instance.setString_2((java.lang.String)memberValue);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        catch (RuntimeException e) {
            throw e;
        }
        catch (Exception e) {
            throw new DeserializationException(new LocalizableExceptionAdapter(e));
        }
    }
    
    public void initialize() {
    }
    
    public void setInstance(Object instance) {
        _instance = (smilehouse.openinterface.OpenInterfaceIF_openHQLIterator_RequestStruct)instance;
    }
    
    public Object getInstance() {
        return _instance;
    }
}
