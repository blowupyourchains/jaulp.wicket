package org.jaulp.wicket.components.termofuse.rightsandduties;

import java.io.Serializable;

import org.jaulp.wicket.components.i18n.list.ContentListModel;
import org.jaulp.wicket.components.i18n.list.HeaderContentListModel;

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
public class RightsAndDutiesModel implements Serializable {

	private static final long serialVersionUID = 1L;

	HeaderContentListModel introductionModel;
	
	ContentListModel listModel;
	
	ContentListModel summaryModel;

}
