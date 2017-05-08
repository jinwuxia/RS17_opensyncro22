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

public class AccessDeniedException_SOAPBuilder implements SOAPInstanceBuilder {
    private smilehouse.openinterface.AccessDeniedException _instance;
    private java.lang.String message;
    private static final int myMESSAGE_INDEX = 0;
    
    public AccessDeniedException_SOAPBuilder() {
    }
    
    
    public AccessDeniedException_SOAPBuilder(java.lang.String message) {
        this.message = message;
    }
    
    public void setMessage(java.lang.String message) {
        this.message = message;
    }
    
    public int memberGateType(int memberIndex) {
        switch (memberIndex) {
            case myMESSAGE_INDEX:
                return GATES_CONSTRUCTION | REQUIRES_INITIALIZATION;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public void construct() {
        _instance = new smilehouse.openinterface.AccessDeniedException(message);
    }
    
    public void setMember(int index, Object memberValue) {
        try {
            switch(index) {
                case myMESSAGE_INDEX:
                    setMessage((java.lang.String)memberValue);
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
        _instance = (smilehouse.openinterface.AccessDeniedException)instance;
    }
    
    public Object getInstance() {
        return _instance;
    }
}
