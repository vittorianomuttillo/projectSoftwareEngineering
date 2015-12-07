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

public abstract class _InserisciTimerecordHandlerDisp extends Ice.ObjectImpl implements InserisciTimerecordHandler
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Handler::InserisciTimerecordHandler",
        "::Ice::Object"
    };

    public boolean ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[] ice_ids()
    {
        return __ids;
    }

    public String[] ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String ice_id()
    {
        return __ids[0];
    }

    public String ice_id(Ice.Current __current)
    {
        return __ids[0];
    }

    public static String ice_staticId()
    {
        return __ids[0];
    }

    public final String getElencoTask(int id)
    {
        return getElencoTask(id, null);
    }

    public final boolean inserisciTimerecord(String descrizione, long datai, long dataf, long secondi, String nomeTask, String sottoprogetto, String progetto, int idDip)
    {
        return inserisciTimerecord(descrizione, datai, dataf, secondi, nomeTask, sottoprogetto, progetto, idDip, null);
    }

    public static Ice.DispatchStatus ___getElencoTask(InserisciTimerecordHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        int id;
        id = __is.readInt();
        __inS.endReadParams();
        String __ret = __obj.getElencoTask(id, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        __os.writeString(__ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___inserisciTimerecord(InserisciTimerecordHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String descrizione;
        long datai;
        long dataf;
        long secondi;
        String nomeTask;
        String sottoprogetto;
        String progetto;
        int idDip;
        descrizione = __is.readString();
        datai = __is.readLong();
        dataf = __is.readLong();
        secondi = __is.readLong();
        nomeTask = __is.readString();
        sottoprogetto = __is.readString();
        progetto = __is.readString();
        idDip = __is.readInt();
        __inS.endReadParams();
        boolean __ret = __obj.inserisciTimerecord(descrizione, datai, dataf, secondi, nomeTask, sottoprogetto, progetto, idDip, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        __os.writeBool(__ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "getElencoTask",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "inserisciTimerecord"
    };

    public Ice.DispatchStatus __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___getElencoTask(this, in, __current);
            }
            case 1:
            {
                return ___ice_id(this, in, __current);
            }
            case 2:
            {
                return ___ice_ids(this, in, __current);
            }
            case 3:
            {
                return ___ice_isA(this, in, __current);
            }
            case 4:
            {
                return ___ice_ping(this, in, __current);
            }
            case 5:
            {
                return ___inserisciTimerecord(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    protected void __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice(ice_staticId(), -1, true);
        __os.endWriteSlice();
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        __is.endReadSlice();
    }

    public static final long serialVersionUID = 0L;
}
