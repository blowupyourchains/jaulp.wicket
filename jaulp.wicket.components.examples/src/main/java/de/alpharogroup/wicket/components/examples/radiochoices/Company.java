package de.alpharogroup.wicket.components.examples.radiochoices;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Builder;
@Getter 
@Setter 
@EqualsAndHashCode 
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company implements Serializable {
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	String name;
}