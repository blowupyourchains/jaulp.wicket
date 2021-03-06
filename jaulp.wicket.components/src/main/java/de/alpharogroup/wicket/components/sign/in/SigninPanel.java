/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.alpharogroup.wicket.components.sign.in;

import static org.wicketeer.modelfactory.ModelFactory.from;
import static org.wicketeer.modelfactory.ModelFactory.model;
import lombok.Getter;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.alpharogroup.auth.models.SignInModel;
import de.alpharogroup.wicket.base.BasePanel;
import de.alpharogroup.wicket.base.util.resource.ResourceModelFactory;
import de.alpharogroup.wicket.components.labeled.textfield.LabeledEmailTextFieldPanel;
import de.alpharogroup.wicket.components.labeled.textfield.LabeledPasswordTextFieldPanel;

/**
 * The Class {@link SigninPanel}.
 */
public class SigninPanel<T extends SignInModel> extends BasePanel<T>
{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant LOGGER. */
	protected static final Logger LOGGER = LoggerFactory.getLogger(SigninPanel.class);

	/** The email. */
	@Getter
	private final Component email;

	/** The password. */
	@Getter
	private final Component password;

	/**
	 * Instantiates a new {@link SigninPanel}.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 */
	public SigninPanel(final String id, final IModel<T> model)
	{
		super(id, model);
		add(email = newEmailTextField("email", model));
		add(password = newPasswordTextField("password", model));
	}

	/**
	 * Factory method for creating the EmailTextField for the email. This method is invoked in the
	 * constructor from the derived classes and can be overridden so users can provide their own
	 * version of a EmailTextField for the email.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the text field
	 */
	protected Component newEmailTextField(final String id, final IModel<T> model)
	{
		final IModel<String> labelModel = ResourceModelFactory.newResourceModel(
			"global.email.label", this);
		final IModel<String> placeholderModel = ResourceModelFactory.newResourceModel(
			"global.enter.your.email.label", this);
		final LabeledEmailTextFieldPanel<T> emailTextField = new LabeledEmailTextFieldPanel<T>(id,
			model, labelModel)
		{

			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected EmailTextField newEmailTextField(final String id, final IModel<T> m)
			{
				final EmailTextField emailTextField = new EmailTextField(id, model(from(
					model.getObject()).getEmail()));
				emailTextField.setOutputMarkupId(true);
				emailTextField.setRequired(true);
				if (placeholderModel != null)
				{
					emailTextField.add(new AttributeAppender("placeholder", placeholderModel));
				}
				return emailTextField;
			}
		};

		return emailTextField;
	}

	/**
	 * Factory method for creating the EmailTextField for the password. This method is invoked in
	 * the constructor from the derived classes and can be overridden so users can provide their own
	 * version of a EmailTextField for the password.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the text field
	 */
	protected Component newPasswordTextField(final String id, final IModel<T> model)
	{
		final IModel<String> labelModel = ResourceModelFactory.newResourceModel(
			"global.password.label", this);
		final IModel<String> placeholderModel = ResourceModelFactory.newResourceModel(
			"global.enter.your.password.label", this);
		final LabeledPasswordTextFieldPanel<T> pwTextField = new LabeledPasswordTextFieldPanel<T>(
			id, model, labelModel)
		{

			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 1L;

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected PasswordTextField newPasswordTextField(final String id, final IModel<T> model)
			{
				final PasswordTextField pwTextField = new PasswordTextField(id, model(from(model)
					.getPassword()));
				pwTextField.setOutputMarkupId(true);
				if (placeholderModel != null)
				{
					pwTextField.add(new AttributeAppender("placeholder", placeholderModel));
				}
				return pwTextField;
			}
		};
		return pwTextField;
	}

}
