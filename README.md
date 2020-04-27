# final-project-team-59
final-project-team-59 created by GitHub Classroom

How program functions:
Run main method in **TradingSystemRunner** class, the program automatically runs from reading in provided market data to publishing output.csv.

•	Main service classes: 
•	**EquityMarketDataService**: with imported data transmitted from EquityMarketDataConnector, create Order Books for different equity products 
•	**EquityAlgoExecutionService**: process and execute orders, output ExecutionOrder<Equity>. Provide options to capture null bid and/or offer stacks input, equal or non-equal prices and quantities of bids and offers.
•	**EquityTradeBookingService**: book trade, output Trade<Equity>. Provide options to classify Trades with different Book IDs.  
•	**EquityPositionService**: add trade to book position, output Position<Equity>. Options: if Book does not exist in PositionMap, generate new Position<Equity> and add it to PositionMap, else updating existing Position<Equity> through updating quantity. 
•	**EquityPnLService**: assess the trade risks using Profit and Loss Explained statement, output PnL<Equity>. Options: if Book does not exist in pnlMap, generate new PnL<Equity> and add to pnlMap, else updating PnL<Equity> through updating variable pnl. 

•	Unit test cases
•	**Test cases 1-6**: test class name: EquityAlgoExecutionServiceTest. Class being tested: EquityAlgoExecutionService. Testing goals: if equal and non-equal prices and quantities of bid and offer orders can be properly processed
•	**Test cases 7-8**: test class name: EquityHistoricalDataConnectorTest. Class being tested: EquityHistoricalDataConnector. Testing goals: if a new csv output file can be successfully generated; if data can be added to existing csv file
•	**Test cases 9-10**: test class name: EquityPnLServiceTest. Class being tested: EquityPnLService. Testing goals: if pnlMap can be properly updated when Book exists or does not exist in pnlMap.
•	**Test cases 11-16**: test class name: TestTradingSystem. Classes being tested: MarketDataConnector, MarketDataService, AlgoExecutionService, tradeBookingService, PositionService, PnLService and corresponding ServiceListners. Testing goals: test for system linkage, data processing and transmission across these classes. Items checked: i.e.,EquityPositionServiceListerner element, Book1 Position equals to 200, input OrderBook size equals to 3, Execution Order with ticker “APPL” price and quantity equal to 281.32 and 200 respectively, ticker of Trade<Equity> in Book1 equals to “APPL”, pnl value of PnL<Equity> in Book1 equals to 56264.


•	Connector classes:
•	**EquityMarketDataConnector**: it should read in marketdata.txt, construct Order Books, transmit data to EquityMarketDataService through onMessage() method.
•	**EquityHistoricalDataConnector**: generate output.csv using publish() method based on PnL<Equity> data transmitted by EquityHistoricalDataServiceListener.

•	Service listener classes:
•	**EquityAlgoExecutionServiceListener**: it is registered to EquityMarketDataService, and transmit data to EquityAlgoExecutionService via processOrder() method
•	**EquityTradeBookingServiceListener**: it is registered to EquityAlgoExecutionService, and transmit data to EquityTradeBookingService via bookTrades() method
•	**EquityPositionServiceListener**: it is registered to EquityTradeBookingService, and transmit data to EquityPositionService via addTrade() method
•	**EquityPnLServiceListener**: it is registered to EquityPositionService, and transmit data to EquityPnLService via calcPnL() method
•	**EquityHistoricalDataServiceListener**: it is registered to EquityPnLService, and transmit data to EquityHistoricalDataConnector via publish() method

•	Side classes:
•	**Equity**: variables: String ticker, long totalShares, double dividendYield
•	**BidOffer**: variables: Order bidOrder, Order offerOrder
•	**Order**: variables: double price, long quantity, PricingSide side
•	**OrderBook**: variables: T product, i.e., Equity, PriorityQueue<Equity> bidStack, PriorityQueue<Equity> offerStack,
•	**ExecutionOrder**: variables: T product, i.e., Equity, PricingSide side, String ticker, OrderType orderType, long quantity, double price
•	**Trade**: variables: T product, i.e, Equity, PricingSide side, String tradeID, String book, long quantity, double price
•	**Position**: variables: T product, i.e., Equity, HashMap<String, long> positions
•	**PnL**: variables: T product, i.e., Equity, String book, double pnl
•	**OrderType**: five order types: FOK, IOC, MARKET, LIMIT,STOP
•	**PricingSide**: two Pricing sides: BID and OFFER
•	**TradeSide**: two trade sides: Buy and Sell



