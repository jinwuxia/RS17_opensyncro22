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


public class OpenInterfaceIF_invokeEvent_RequestStruct {
    protected smilehouse.openinterface.LoginInfo loginInfo_1;
    protected java.lang.String string_2;
    protected java.lang.Object object_3;
    
    public OpenInterfaceIF_invokeEvent_RequestStruct() {
    }
    
    public OpenInterfaceIF_invokeEvent_RequestStruct(smilehouse.openinterface.LoginInfo loginInfo_1, java.lang.String string_2, java.lang.Object object_3) {
        this.loginInfo_1 = loginInfo_1;
        this.string_2 = string_2;
        this.object_3 = object_3;
    }
    
    public smilehouse.openinterface.LoginInfo getLoginInfo_1() {
        return loginInfo_1;
    }
    
    public void setLoginInfo_1(smilehouse.openinterface.LoginInfo loginInfo_1) {
        this.loginInfo_1 = loginInfo_1;
    }
    
    public java.lang.String getString_2() {
        return string_2;
    }
    
    public void setString_2(java.lang.String string_2) {
        this.string_2 = string_2;
    }
    
    public java.lang.Object getObject_3() {
        return object_3;
    }
    
    public void setObject_3(java.lang.Object object_3) {
        this.object_3 = object_3;
    }
}
