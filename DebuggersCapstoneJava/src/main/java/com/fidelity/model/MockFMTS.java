package com.fidelity.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import com.fidelity.utils.PortfolioService;

public class MockFMTS {
   
	public static List<FMTS> MOCK_FMTS = new ArrayList<>() {{
		add(new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",
				new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100)));

		add(new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",
				new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100)));

		add(new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",
				new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100)));

		add(new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",
				new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100)));

		add(new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",
				new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100)));

		add(new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",
				new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100)));

		add(new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",
				new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100)));

		add(new FMTS(104.75, 104.25, "21-AUG-19 10.00.02.002000000 AM GMT",
				new Instrument("T67880", "CUSIP",  "9128285U0", "GOVT", "USA, Note 1.5 31dec2023 5Y", 10000, 100)));
	}};

	public static List<FMTS> getMOCK_FMTS() {
		return MOCK_FMTS;
	}
	
}
