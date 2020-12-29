package org.springframework.samples.webflow.ajax;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.util.StringUtils;
import org.springframework.webflow.execution.RequestContext;

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;
	
	private static final Logger log = LoggerFactory.getLogger(UserBean.class);

	public String createEmailSuggestion(RequestContext context) {
		
		boolean haveFirst = StringUtils.hasText(firstName);
		boolean haveLast = StringUtils.hasLength(lastName);

		if (haveFirst && haveLast) {
			return firstName + "." + lastName + "@fastmailTESTDEBUG.com";

		} else if (haveFirst) {
			return firstName + "@fastmail.com";

		} else if (haveLast) {
			return lastName + "@fastmail.com";

		} else {
			context.getMessageContext().addMessage(
					new MessageBuilder().error().defaultText("Please enter a first or a last name or both!").build());
			return "";
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
