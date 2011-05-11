/*
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.services.jcr.dataflow;

import org.exoplatform.services.jcr.observation.ExtendedEventType;

import java.util.List;

/**
 * Created by The eXo Platform SAS.<br/> Plain changes log implementation (i.e. no nested logs
 * inside)
 * 
 * @author Gennady Azarenkov
 * @version $Id: PlainChangesLog.java 1518 2010-01-20 23:33:30Z sergiykarpenko $
 */
public interface PlainChangesLog extends ItemStateChangesLog
{

   /**
    * Return Sesion Id.
    * 
    * @return sessionId of a session produced this changes log
    */
   String getSessionId();
   
   /**
    * Return pair Id of system and non-system logs.
    * 
    * @return pairId of a pair, null if no pair found.
    */
   String getPairId();

   /**
    * Return this log event type.
    * 
    * @return int, event type produced this log
    * @see ExtendedEventType
    */
   int getEventType();

   /**
    * Adds an item state object to the bottom of this log.
    * 
    * @param state ItemState
    */
   PlainChangesLog add(ItemState state);

   /**
    * Adds list of states object to the bottom of this log.
    *  
    * @param states List of ItemState
    */
   PlainChangesLog addAll(List<ItemState> states);
}
