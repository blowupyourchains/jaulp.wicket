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

import java.util.Date;

import lombok.Getter;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.yui.calendar.DateTimeField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import de.alpharogroup.wicket.components.factory.ComponentFactory;
import de.alpharogroup.wicket.components.labeled.LabeledFormComponentPanel;

/**
 * Convenience class for labeled DateTextfield.
 *
 * @param <T>
 *            the generic type of model object
 */
public class LabeledDateTimeFieldPanel<T> extends LabeledFormComponentPanel<T>
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The text field. */
	@Getter
	private final DateTimeField dateTimeField;

	/**
	 * Instantiates a new {@link LabeledDateTimeFieldPanel}.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @param labelModel
	 *            the label model
	 */
	public LabeledDateTimeFieldPanel(final String id, final IModel<T> model,
		final IModel<String> labelModel)
	{
		super(id, model, labelModel);
		add(dateTimeField = newDateTimeField("dateTimeField", model));

		add(feedback = newComponentFeedbackPanel("feedback", dateTimeField));

		final String markupId = dateTimeField.getMarkupId();
		add(label = newLabel("label", markupId, getLabel()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void convertInput()
	{
		setConvertedInput(getModel().getObject());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Component getFormComponent()
	{
		return this.dateTimeField;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getInput()
	{
		return dateTimeField.getInput();
	}

	/**
	 * Factory method for create the new {@link DateTimeField}. This method is invoked in the
	 * constructor from the derived classes and can be overridden so users can provide their own
	 * version of a new {@link DateTimeField}.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the new {@link DateTimeField}
	 */
	protected DateTimeField newDateTimeField(final String id, final IModel<T> model)
	{
		final IModel<Date> textFieldModel = new PropertyModel<>(model.getObject(), getId());
		return ComponentFactory.newDateTimeField(id, textFieldModel);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onBeforeRender()
	{
		dateTimeField.setRequired(isRequired());
		super.onBeforeRender();
	}
}
