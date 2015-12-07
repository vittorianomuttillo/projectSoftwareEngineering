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
// Generated from file `creaTaskHandler.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Handler;

public abstract class _GestisciTaskHandlerDisp extends Ice.ObjectImpl implements GestisciTaskHandler
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Handler::GestisciTaskHandler",
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

    public final java.util.List<String[]> aggiornaElencoDipendenti(java.util.List<String[]> elencoDip, int idDipendente, String unita, double quantita)
    {
        return aggiornaElencoDipendenti(elencoDip, idDipendente, unita, quantita, null);
    }

    public final void aggiungiDipendente(String aNomeProgetto, String aNomeSottoprogetto, String nomeTask, int IdDipendente, String unita, double quantita)
    {
        aggiungiDipendente(aNomeProgetto, aNomeSottoprogetto, nomeTask, IdDipendente, unita, quantita, null);
    }

    public final void cancellaTask(String aNomeProgetto, String aNomeSottoprogetto, String nomeTask)
    {
        cancellaTask(aNomeProgetto, aNomeSottoprogetto, nomeTask, null);
    }

    public final void creaTask(String NomeProgetto, String NomeSottoprogetto, String Descrizione, java.util.List<String[]> IdDipendente, String nomeTask)
    {
        creaTask(NomeProgetto, NomeSottoprogetto, Descrizione, IdDipendente, nomeTask, null);
    }

    public final void eliminaDipendente(String aNomeProgetto, String aNomeSottoprogetto, String nomeTask, int IdDipendente)
    {
        eliminaDipendente(aNomeProgetto, aNomeSottoprogetto, nomeTask, IdDipendente, null);
    }

    public final String getDipendenti()
    {
        return getDipendenti(null);
    }

    public final String getInfoSottoprogetto(String nomeProgetto, String nomeSottoprogetto)
    {
        return getInfoSottoprogetto(nomeProgetto, nomeSottoprogetto, null);
    }

    public final String getInfoTask(String nomeProgetto, String nomeSottoprogetto, String nomeTask)
    {
        return getInfoTask(nomeProgetto, nomeSottoprogetto, nomeTask, null);
    }

    public final String getSottoprogetti(int idManager)
    {
        return getSottoprogetti(idManager, null);
    }

    public final void modificaTask(String aNomeProgetto, String aNomeSottoprogetto, String aDescrizione, String nomeTask, String oldNomeTask)
    {
        modificaTask(aNomeProgetto, aNomeSottoprogetto, aDescrizione, nomeTask, oldNomeTask, null);
    }

    public final void sostituisciDipendente(String aNomeProgetto, String aNomeSottoprogetto, String nomeTask, int IdDipendente, String unita, double quantita, int IdDipendenteOld)
    {
        sostituisciDipendente(aNomeProgetto, aNomeSottoprogetto, nomeTask, IdDipendente, unita, quantita, IdDipendenteOld, null);
    }

    public static Ice.DispatchStatus ___creaTask(GestisciTaskHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String NomeProgetto;
        String NomeSottoprogetto;
        String Descrizione;
        java.util.List<String[]> IdDipendente;
        String nomeTask;
        NomeProgetto = __is.readString();
        NomeSottoprogetto = __is.readString();
        Descrizione = __is.readString();
        IdDipendente = IntArrayListHelper.read(__is);
        nomeTask = __is.readString();
        __inS.endReadParams();
        __obj.creaTask(NomeProgetto, NomeSottoprogetto, Descrizione, IdDipendente, nomeTask, __current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___getSottoprogetti(GestisciTaskHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        int idManager;
        idManager = __is.readInt();
        __inS.endReadParams();
        String __ret = __obj.getSottoprogetti(idManager, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        __os.writeString(__ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___getDipendenti(GestisciTaskHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __inS.readEmptyParams();
        String __ret = __obj.getDipendenti(__current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        __os.writeString(__ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___aggiornaElencoDipendenti(GestisciTaskHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        java.util.List<String[]> elencoDip;
        int idDipendente;
        String unita;
        double quantita;
        elencoDip = IntArrayListHelper.read(__is);
        idDipendente = __is.readInt();
        unita = __is.readString();
        quantita = __is.readDouble();
        __inS.endReadParams();
        java.util.List<String[]> __ret = __obj.aggiornaElencoDipendenti(elencoDip, idDipendente, unita, quantita, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        IntArrayListHelper.write(__os, __ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___getInfoSottoprogetto(GestisciTaskHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String nomeProgetto;
        String nomeSottoprogetto;
        nomeProgetto = __is.readString();
        nomeSottoprogetto = __is.readString();
        __inS.endReadParams();
        String __ret = __obj.getInfoSottoprogetto(nomeProgetto, nomeSottoprogetto, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        __os.writeString(__ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___getInfoTask(GestisciTaskHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String nomeProgetto;
        String nomeSottoprogetto;
        String nomeTask;
        nomeProgetto = __is.readString();
        nomeSottoprogetto = __is.readString();
        nomeTask = __is.readString();
        __inS.endReadParams();
        String __ret = __obj.getInfoTask(nomeProgetto, nomeSottoprogetto, nomeTask, __current);
        IceInternal.BasicStream __os = __inS.__startWriteParams(Ice.FormatType.DefaultFormat);
        __os.writeString(__ret);
        __inS.__endWriteParams(true);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___cancellaTask(GestisciTaskHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String aNomeProgetto;
        String aNomeSottoprogetto;
        String nomeTask;
        aNomeProgetto = __is.readString();
        aNomeSottoprogetto = __is.readString();
        nomeTask = __is.readString();
        __inS.endReadParams();
        __obj.cancellaTask(aNomeProgetto, aNomeSottoprogetto, nomeTask, __current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___modificaTask(GestisciTaskHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String aNomeProgetto;
        String aNomeSottoprogetto;
        String aDescrizione;
        String nomeTask;
        String oldNomeTask;
        aNomeProgetto = __is.readString();
        aNomeSottoprogetto = __is.readString();
        aDescrizione = __is.readString();
        nomeTask = __is.readString();
        oldNomeTask = __is.readString();
        __inS.endReadParams();
        __obj.modificaTask(aNomeProgetto, aNomeSottoprogetto, aDescrizione, nomeTask, oldNomeTask, __current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___aggiungiDipendente(GestisciTaskHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String aNomeProgetto;
        String aNomeSottoprogetto;
        String nomeTask;
        int IdDipendente;
        String unita;
        double quantita;
        aNomeProgetto = __is.readString();
        aNomeSottoprogetto = __is.readString();
        nomeTask = __is.readString();
        IdDipendente = __is.readInt();
        unita = __is.readString();
        quantita = __is.readDouble();
        __inS.endReadParams();
        __obj.aggiungiDipendente(aNomeProgetto, aNomeSottoprogetto, nomeTask, IdDipendente, unita, quantita, __current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___eliminaDipendente(GestisciTaskHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String aNomeProgetto;
        String aNomeSottoprogetto;
        String nomeTask;
        int IdDipendente;
        aNomeProgetto = __is.readString();
        aNomeSottoprogetto = __is.readString();
        nomeTask = __is.readString();
        IdDipendente = __is.readInt();
        __inS.endReadParams();
        __obj.eliminaDipendente(aNomeProgetto, aNomeSottoprogetto, nomeTask, IdDipendente, __current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus ___sostituisciDipendente(GestisciTaskHandler __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String aNomeProgetto;
        String aNomeSottoprogetto;
        String nomeTask;
        int IdDipendente;
        String unita;
        double quantita;
        int IdDipendenteOld;
        aNomeProgetto = __is.readString();
        aNomeSottoprogetto = __is.readString();
        nomeTask = __is.readString();
        IdDipendente = __is.readInt();
        unita = __is.readString();
        quantita = __is.readDouble();
        IdDipendenteOld = __is.readInt();
        __inS.endReadParams();
        __obj.sostituisciDipendente(aNomeProgetto, aNomeSottoprogetto, nomeTask, IdDipendente, unita, quantita, IdDipendenteOld, __current);
        __inS.__writeEmptyParams();
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "aggiornaElencoDipendenti",
        "aggiungiDipendente",
        "cancellaTask",
        "creaTask",
        "eliminaDipendente",
        "getDipendenti",
        "getInfoSottoprogetto",
        "getInfoTask",
        "getSottoprogetti",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "modificaTask",
        "sostituisciDipendente"
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
                return ___aggiornaElencoDipendenti(this, in, __current);
            }
            case 1:
            {
                return ___aggiungiDipendente(this, in, __current);
            }
            case 2:
            {
                return ___cancellaTask(this, in, __current);
            }
            case 3:
            {
                return ___creaTask(this, in, __current);
            }
            case 4:
            {
                return ___eliminaDipendente(this, in, __current);
            }
            case 5:
            {
                return ___getDipendenti(this, in, __current);
            }
            case 6:
            {
                return ___getInfoSottoprogetto(this, in, __current);
            }
            case 7:
            {
                return ___getInfoTask(this, in, __current);
            }
            case 8:
            {
                return ___getSottoprogetti(this, in, __current);
            }
            case 9:
            {
                return ___ice_id(this, in, __current);
            }
            case 10:
            {
                return ___ice_ids(this, in, __current);
            }
            case 11:
            {
                return ___ice_isA(this, in, __current);
            }
            case 12:
            {
                return ___ice_ping(this, in, __current);
            }
            case 13:
            {
                return ___modificaTask(this, in, __current);
            }
            case 14:
            {
                return ___sostituisciDipendente(this, in, __current);
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
