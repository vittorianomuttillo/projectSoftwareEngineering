package ui.Command;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextField;

import Handler.InserisciTimerecordHandlerPrx;
import Handler.ProxieFactory;
import ui.Home.Home;
import ui.InserisciTimeRecord.InserisciTimeRecord;

public class InserisciTimeRecordCommand extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private InserisciTimeRecord lgn;
	private String nomep;
	private String nomes;
	private String nomet;
	private long datai; 
	private long dataf; 
	private long milli;
	private int idDip;
	
	public InserisciTimeRecordCommand(InserisciTimeRecord log, JTextField desc, String p, String s, String t, long i, long f, long m, int dip){
		super("Inserisci Time Record");
		this.lgn = log;
		this.nomep = p;
		this.nomes = s;
		this.nomet = t;
		this.datai = i;
		this.dataf = f;
		this.milli = m;
		this.idDip = dip;
		this.lgn = log;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		InserisciTimerecordHandlerPrx handler = (InserisciTimerecordHandlerPrx) ProxieFactory.factoryMethod("InserisciTimerecordHandler", null, null, null);

		handler.inserisciTimerecord(this.lgn.getDescrizioneTask().getText(), this.datai, this.dataf, this.milli, this.nomet, this.nomes, this.nomep, this.idDip);
		Home.AggiornaGUI(Home.getTipo());
		lgn.getFf().dispose();
	}
	
	
}
