// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `InserisciTimerecord.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Handler;

public interface _InserisciTimerecordHandlerOperations
{
    String getElencoTask(int id, Ice.Current __current);

    boolean inserisciTimerecord(String descrizione, long datai, long dataf, long secondi, String nomeTask, String sottoprogetto, String progetto, int idDip, Ice.Current __current);
}
