/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.hupa.shared.rpc;

import java.io.Serializable;

import net.customware.gwt.dispatch.shared.Result;

<<<<<<< HEAD
<<<<<<< HEAD
import org.apache.hupa.shared.data.User;
import org.apache.hupa.shared.proxy.IMAPFolderProxy;
=======
import org.apache.hupa.shared.data.IMAPFolder;
import org.apache.hupa.shared.data.User;
>>>>>>> first commit
=======
import org.apache.hupa.shared.data.User;
import org.apache.hupa.shared.proxy.IMAPFolderProxy;
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.

public class DeleteMessageResult implements Result, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5149203502019947912L;
    private User user;
<<<<<<< HEAD
<<<<<<< HEAD
    private IMAPFolderProxy folder;
=======
    private IMAPFolder folder;
>>>>>>> first commit
=======
    private IMAPFolderProxy folder;
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
    private int deleteCount;


    
    @SuppressWarnings("unused")
    private DeleteMessageResult() {
        
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
    public DeleteMessageResult(User user,IMAPFolderProxy folder, int deleteCount) {
=======
    public DeleteMessageResult(User user,IMAPFolder folder, int deleteCount) {
>>>>>>> first commit
=======
    public DeleteMessageResult(User user,IMAPFolderProxy folder, int deleteCount) {
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        this.user = user;
        this.folder = folder;
        this.deleteCount = deleteCount;
    }
    
    public int getCount() {
        return deleteCount;
    }
    
    public User getUser() {
        return user;
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
    public IMAPFolderProxy getFolder() {
=======
    public IMAPFolder getFolder() {
>>>>>>> first commit
=======
    public IMAPFolderProxy getFolder() {
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        return folder;
    }

}
