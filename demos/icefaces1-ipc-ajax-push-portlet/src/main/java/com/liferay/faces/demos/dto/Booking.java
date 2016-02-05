/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.demos.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * @author  Neil Griffin
 */
public class Booking implements Serializable {

	private static final long serialVersionUID = -8200033894302777949L;

	private long bookingTypeId;
	private long customerId;
	private Date startDate;
	private Date finishDate;

	public Booking(long bookingTypeId, long customerId) {
		Calendar today = new GregorianCalendar();
		Calendar weekFromToday = (Calendar) today.clone();
		weekFromToday.add(Calendar.DATE, 7);
		this.bookingTypeId = bookingTypeId;
		this.customerId = customerId;
		startDate = new Date(today.getTimeInMillis());
		finishDate = new Date(weekFromToday.getTimeInMillis());
	}

	public Booking(long bookingTypeId, long customerId, Date startDate, Date finishDate) {
		this.bookingTypeId = bookingTypeId;
		this.customerId = customerId;
		this.startDate = startDate;
		this.finishDate = finishDate;
	}

	public long getBookingTypeId() {
		return bookingTypeId;
	}

	public void setBookingTypeId(long bookingTypeId) {
		this.bookingTypeId = bookingTypeId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}