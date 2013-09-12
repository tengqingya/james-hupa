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

package org.apache.hupa.shared.events;

import java.util.ArrayList;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import org.apache.hupa.shared.data.ImapFolderImpl;
import org.apache.hupa.shared.domain.Message;
<<<<<<< HEAD
import org.apache.hupa.shared.domain.User;
=======
import org.apache.hupa.shared.data.IMAPFolder;
=======
import org.apache.hupa.shared.data.ImapFolderImpl;
>>>>>>> Make the ValueProxy(ImapFolder) work with Manolo's patch. Hupa can display folders in west view with RequestFactory now.
import org.apache.hupa.shared.data.Message;
import org.apache.hupa.shared.data.User;
>>>>>>> first commit
=======
import org.apache.hupa.shared.data.IMAPFolder;
import org.apache.hupa.shared.data.Message;
<<<<<<< HEAD
import org.apache.hupa.shared.data.User;
>>>>>>> first commit
=======
=======
>>>>>>> try to change fetch messages to use RF
import org.apache.hupa.shared.domain.User;
>>>>>>> Make chechsession and login work with RF, with refactoring fetch folders.

import com.google.gwt.event.shared.GwtEvent;

public class DeleteMessageEvent extends GwtEvent<DeleteMessageEventHandler>{

    public final static Type<DeleteMessageEventHandler> TYPE = new Type<DeleteMessageEventHandler>();
    private User user;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private ImapFolderImpl folder;
=======
    private IMAPFolder folder;
>>>>>>> first commit
=======
    private IMAPFolder folder;
>>>>>>> first commit
=======
    private ImapFolderImpl folder;
>>>>>>> Make the ValueProxy(ImapFolder) work with Manolo's patch. Hupa can display folders in west view with RequestFactory now.
    private ArrayList<Message> messageList;
    @Override
    protected void dispatch(DeleteMessageEventHandler handler) {
        handler.onDeleteMessageEvent(this);
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<DeleteMessageEventHandler> getAssociatedType() {
        return TYPE;
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public DeleteMessageEvent(User user, ImapFolderImpl folder, ArrayList<Message> messageList) {
=======
    public DeleteMessageEvent(User user, IMAPFolder folder, ArrayList<Message> messageList) {
>>>>>>> first commit
=======
    public DeleteMessageEvent(User user, IMAPFolder folder, ArrayList<Message> messageList) {
>>>>>>> first commit
=======
    public DeleteMessageEvent(User user, ImapFolderImpl folder, ArrayList<Message> messageList) {
>>>>>>> Make the ValueProxy(ImapFolder) work with Manolo's patch. Hupa can display folders in west view with RequestFactory now.
        this.user = user;
        this.folder = folder;
        this.messageList = messageList;
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public DeleteMessageEvent(User user, ImapFolderImpl folder, Message message) {
=======
    public DeleteMessageEvent(User user, IMAPFolder folder, Message message) {
>>>>>>> first commit
=======
    public DeleteMessageEvent(User user, IMAPFolder folder, Message message) {
>>>>>>> first commit
=======
    public DeleteMessageEvent(User user, ImapFolderImpl folder, Message message) {
>>>>>>> Make the ValueProxy(ImapFolder) work with Manolo's patch. Hupa can display folders in west view with RequestFactory now.
        ArrayList<Message> mList = new ArrayList<Message>();
        mList.add(message);
        
        this.user = user;
        this.folder = folder;
        this.messageList = mList;
    }
    public User getUser() {
        return user;
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public ImapFolderImpl getFolder() {
=======
    public IMAPFolder getFolder() {
>>>>>>> first commit
=======
    public IMAPFolder getFolder() {
>>>>>>> first commit
=======
    public ImapFolderImpl getFolder() {
>>>>>>> Make the ValueProxy(ImapFolder) work with Manolo's patch. Hupa can display folders in west view with RequestFactory now.
        return folder;
    }
    
    public ArrayList<Message> getMessages() {
        return messageList;
    }

}
