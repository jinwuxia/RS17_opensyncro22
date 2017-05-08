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

package smilehouse.xml.chopper;

/**
 * Simple interface for getting characters in a streaming style.
 * Also a pushBack-method is provided.
 */
public interface CharInput {

    /**
     * Return next character.
     * @return
     */
    public int nextChar() throws CharInputException;
    
    /**
     * Push the last character back, so that it will be returned by the next call to 'nextChar'.
     *
     */
    public void pushBack() throws CharInputException;
}
