import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

/**
 * unit test for EquityPnLService
 * @author Sara Liu, Wenting Yang
 *
 */

class EquityPnLServiceTest {

	//Book1 does not exist in PnLMap
	@Test
	void testCalcPnLBookNotExist() {
		Equity eq = new Equity("APPL",438000000,1.06);
		Trade<Equity> tr = new Trade<Equity>(eq, "203912", 238.15, "Book1", 820, TradeSide.values()[1]);
		EquityPnLService EPLService = EquityPnLService.getInstance();
		HashMap<String,PnL<Equity>> pnlMap = new HashMap<String,PnL<Equity>>();
		EPLService.calcPnL(tr);
	    PnL<Equity> PnL = EPLService.getData("Book1");
		assertEquals(195283.0, Math.round(PnL.getPnl()*100.0)/100.0, "pnl value is wrong, should be 195283.0");
	}
	
	//Book1 exists in PnLMap
	@Test
	void testCalcPnLBookExists() {
		Equity eq = new Equity("APPL",438000000,1.06);
		EquityPnLService EPLService = EquityPnLService.getInstance();
	    Trade<Equity> new_tr = new Trade<Equity>(eq, "203913", 185.36, "Book1", 4000, TradeSide.values()[0]);
	    EPLService.calcPnL(new_tr);
	    PnL<Equity> PnL=EPLService.getPnLMap().get("Book1");
		assertEquals(-546157.0, Math.round(PnL.getPnl()*100.0)/100.0, "pnl value is wrong, should be -546157.0");
	}

}
