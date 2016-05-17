package com.daloz.mycv.domain;

import java.io.Serializable;

import com.daloz.mycv.domain.helper.ITextMutableObject;

public class SeminarDTO implements Serializable, ITextMutableObject
{

	@Override
	public String getStringFromMutableObject()
	{
		return getStringInformation(this);
	}

}
