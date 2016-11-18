/*
  Exadel AMF-serializer
  Copyright (C) 2008 Exadel, Inc.

  AMF-serializer is free software; you can redistribute it and/or modify
  it under the terms of the GNU Lesser General Public License as published by
  the Free Software Foundation

  IAMF3MessageProcessor.java
  Last modified by: $Author$
  $Revision$   $Date$
*/

package com.weedong.flex.amf.process;

import com.weedong.flex.messaging.messages.Message;

/**
 * Interface for classes which provides processing of AMF3Message.
 * 
 * @author apleskatsevich
 */
public interface IAMF3MessageProcessor {

    /**
     * Process amf3 message.
     * 
     * @param amf3Message Message to process
     * 
     * @return Result of processing
     */
    Message process(Message amf3Message);
    
}
