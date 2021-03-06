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
package de.alpharogroup.wicket.components.labeled.textfield;

import lombok.Getter;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import de.alpharogroup.wicket.components.factory.ComponentFactory;
import de.alpharogroup.wicket.components.labeled.LabeledFormComponentPanel;

/**
 * Convenience class for labeled {@link PasswordTextField}.
 *
 * @param <T>
 *            the generic type of model object
 *
 */
public class LabeledPasswordTextFieldPanel<T> extends LabeledFormComponentPanel<T>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The text field. */
	@Getter
	private final PasswordTextField passwordTextField;

	/**
	 * Instantiates a new {@link LabeledPasswordTextFieldPanel}.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @param labelModel
	 *            the label model
	 */
	public LabeledPasswordTextFieldPanel(final String id, final IModel<T> model,
		final IModel<String> labelModel)
	{
		super(id, model, labelModel);

		add(passwordTextField = newPasswordTextField("passwordTextField", model));

		add(feedback = newComponentFeedbackPanel("feedback", passwordTextField));

		final String markupId = passwordTextField.getMarkupId();
		add(label = newLabel("label", markupId, getLabel()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void convertInput()
	{
		setConvertedInput(getModel().getObject());
		// final IModel<T> m = getModel();
		// final T t = m.getObject();
		// try {
		// String input = getInput();
		// BeanUtils.setProperty(t, getId(), input);
		// } catch (IllegalAccessException | InvocationTargetException e) {
		// LOGGER.error("Set password bean failed.", e);
		// }
		// setConvertedInput(t);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Component getFormComponent()
	{
		return this.passwordTextField;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInput()
	{
		return passwordTextField.getInput();
	}

	/**
	 * Factory method for create the new {@link PasswordTextField}. This method is invoked in the
	 * constructor from the derived classes and can be overridden so users can provide their own
	 * version of a new {@link PasswordTextField}.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the new {@link PasswordTextField}
	 */
	protected PasswordTextField newPasswordTextField(final String id, final IModel<T> model)
	{
		return ComponentFactory.newPasswordTextField(id,
			new PropertyModel<String>(model.getObject(), getId()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onBeforeRender()
	{
		passwordTextField.setRequired(isRequired());
		super.onBeforeRender();
	}
}
