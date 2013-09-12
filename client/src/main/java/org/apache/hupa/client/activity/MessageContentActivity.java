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

package org.apache.hupa.client.activity;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> fixed issue#64, add attachments region in message content view
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<< HEAD
import org.apache.hupa.client.place.ComposePlace;
import org.apache.hupa.client.place.MessagePlace.TokenWrapper;
import org.apache.hupa.client.rf.GetMessageDetailsRequest;
<<<<<<< HEAD
import org.apache.hupa.client.ui.ToolBarView.Parameters;
import org.apache.hupa.shared.SConsts;
import org.apache.hupa.shared.domain.GetMessageDetailsAction;
import org.apache.hupa.shared.domain.GetMessageDetailsResult;
import org.apache.hupa.shared.domain.ImapFolder;
import org.apache.hupa.shared.domain.MessageAttachment;
import org.apache.hupa.shared.events.DeleteClickEvent;
import org.apache.hupa.shared.events.DeleteClickEventHandler;
import org.apache.hupa.shared.events.MailToEvent;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class MessageContentActivity extends AppBaseActivity {

	private static final Logger log = Logger.getLogger(MessageContentActivity.class.getName());

	@Inject private Displayable display;
	private String fullName;
	private String uid;

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		bindTo(eventBus);
		display.getRawPanel().setVisible(false);
		if (isUidSet()) {
			display.getRawPanel().setVisible(true);
			GetMessageDetailsRequest req = rf.messageDetailsRequest();
			GetMessageDetailsAction action = req.create(GetMessageDetailsAction.class);
			final ImapFolder f = req.create(ImapFolder.class);
			f.setFullName(fullName);
			action.setFolder(f);
			action.setUid(Long.parseLong(uid));
			req.get(action).fire(new Receiver<GetMessageDetailsResult>() {
				@Override
				public void onSuccess(GetMessageDetailsResult response) {
					display.fillMessageContent(response.getMessageDetails().getText());
					List<MessageAttachment> attaches = response.getMessageDetails().getMessageAttachments();
					if (attaches == null || attaches.isEmpty()) {
						display.showAttachmentPanel(false);
					} else {
						display.showAttachmentPanel(true);
						display.setAttachments(response.getMessageDetails().getMessageAttachments(), fullName,
								Long.parseLong(uid));
					}
				}

				@Override
				public void onFailure(ServerFailure error) {
					if (error.isFatal()) {
						log.log(Level.SEVERE, error.getMessage());
						// TODO write the error message to status bar.
						throw new RuntimeException(error.getMessage());
					}
				}
			});
		}
		container.setWidget(display.asWidget());
		exportJSMethods(this);
	}

	private void bindTo(EventBus eventBus) {
		eventBus.addHandler(DeleteClickEvent.TYPE, new DeleteClickEventHandler() {
			@Override
			public void onDeleteClickEvent(DeleteClickEvent event) {
				display.clearContent();
			}
		});
		this.registerHandler(display.getRaw().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				String message_url = GWT.getModuleBaseURL() + SConsts.SERVLET_SOURCE + "?" + SConsts.PARAM_UID + "="
						+ uid + "&" + SConsts.PARAM_FOLDER + "=" + fullName;
				Window.open(message_url, "_blank", "");
			}

		}));
	}

	private boolean isUidSet() {
		return uid != null && uid.matches("\\d+");
	}

	public interface Displayable extends IsWidget {
		void fillMessageContent(String messageContent);
		void clearContent();
		void setAttachments(List<MessageAttachment> attachements, String folder, long uid);
		void showAttachmentPanel(boolean is);
		HasClickHandlers getRaw();
		HasVisibility getRawPanel();
	}

	public Activity with(TokenWrapper tokenWrapper) {
		fullName = tokenWrapper.getFolder();
		uid = tokenWrapper.getUid();
		return this;
	}

	public void openLink(String url) {
		Window.open(url, "_blank", "");
	}

	public void mailTo(String mailto) {
		pc.goTo(new ComposePlace("new").with(new Parameters(null, null, null, null)));
		eventBus.fireEvent(new MailToEvent(mailto));
	}

	private native void exportJSMethods(MessageContentActivity activity)
	/*-{
       $wnd.openLink = function(url) {
       try {
       activity.@org.apache.hupa.client.activity.MessageContentActivity::openLink(Ljava/lang/String;) (url);
       } catch(e) {}
       return false;
       };
       $wnd.mailTo = function(mail) {
       try {
       activity.@org.apache.hupa.client.activity.MessageContentActivity::mailTo(Ljava/lang/String;) (mail);
       } catch(e) {}
       return false;
       };
       }-*/;
=======
=======
import org.apache.hupa.client.place.IMAPMessagePlace;
>>>>>>> make message content work as expected partly
=======
=======
import java.util.logging.Level;
import java.util.logging.Logger;

>>>>>>> scrub code
import org.apache.hupa.client.place.MailFolderPlace;
=======
import org.apache.hupa.client.place.MessagePlace.TokenWrapper;
>>>>>>> change place management and make refresh folder and message list more gentle
import org.apache.hupa.client.rf.GetMessageDetailsRequest;
>>>>>>> make reload message content work, use the same place with folder list, while separated with slash, that looks like Gmail's
import org.apache.hupa.client.ui.WidgetDisplayable;
=======
>>>>>>> replace with IsWidget
import org.apache.hupa.shared.domain.GetMessageDetailsAction;
import org.apache.hupa.shared.domain.GetMessageDetailsResult;
import org.apache.hupa.shared.domain.ImapFolder;
import org.apache.hupa.shared.domain.MessageAttachment;
import org.apache.hupa.shared.events.DeleteClickEvent;
import org.apache.hupa.shared.events.DeleteClickEventHandler;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class MessageContentActivity extends AppBaseActivity {

	private static final Logger log = Logger.getLogger(MessageContentActivity.class.getName());

	@Inject private Displayable display;
	private String fullName;
	private String uid;

	@Override
	public void start(AcceptsOneWidget container, EventBus eventBus) {
		bindTo(eventBus);
		if (isUidSet()) {
			GetMessageDetailsRequest req = rf.messageDetailsRequest();
			GetMessageDetailsAction action = req.create(GetMessageDetailsAction.class);
			final ImapFolder f = req.create(ImapFolder.class);
			f.setFullName(fullName);
			action.setFolder(f);
			action.setUid(Long.parseLong(uid));
			req.get(action).fire(new Receiver<GetMessageDetailsResult>() {
				@Override
				public void onSuccess(GetMessageDetailsResult response) {
					display.fillMessageContent(response.getMessageDetails().getText());
					display.setAttachments(response.getMessageDetails().getMessageAttachments(), fullName, Long.parseLong(uid));
				}

				@Override
				public void onFailure(ServerFailure error) {
					if (error.isFatal()) {
						log.log(Level.SEVERE, error.getMessage());
						// TODO write the error message to status bar.
						throw new RuntimeException(error.getMessage());
					}
				}
			});
		}
		container.setWidget(display.asWidget());
	}

<<<<<<< HEAD
<<<<<<< HEAD
	@Inject private Displayable display;
<<<<<<< HEAD
	
<<<<<<< HEAD
	public interface Displayable extends WidgetDisplayable {}
>>>>>>> integrate all of the views to their corresponding activities and mappers
=======
=======
=======
=======
	private void bindTo(EventBus eventBus) {
		eventBus.addHandler(DeleteClickEvent.TYPE, new DeleteClickEventHandler() {
			@Override
			public void onDeleteClickEvent(DeleteClickEvent event) {
				display.clearContent();
			}
		});
	}

>>>>>>> fixed issue#76 with adding delete handler event
	private boolean isUidSet() {
		return uid != null && uid.matches("\\d+");
	}
>>>>>>> scrub code

<<<<<<< HEAD
>>>>>>> make reload message content work, use the same place with folder list, while separated with slash, that looks like Gmail's
	public interface Displayable extends WidgetDisplayable {
=======
	public interface Displayable extends IsWidget {
>>>>>>> replace with IsWidget
		void fillMessageContent(String messageContent);
		void clearContent();
		void setAttachments(List<MessageAttachment> attachements, String folder, long uid);
	}

	public Activity with(TokenWrapper tokenWrapper) {
		fullName = tokenWrapper.getFolder();
		uid = tokenWrapper.getUid();
		return this;
	}
>>>>>>> make message content work as expected partly
}
