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

public abstract class Callback_InserisciTimerecordHandler_inserisciTimerecord extends Ice.TwowayCallback
{
    public abstract void response(boolean __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        InserisciTimerecordHandlerPrx __proxy = (InserisciTimerecordHandlerPrx)__result.getProxy();
        boolean __ret = false;
        try
        {
            __ret = __proxy.end_inserisciTimerecord(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
