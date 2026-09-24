import { useEffect, useState } from "react";
import OrderForm from "./components/TradeEntry";

function App() {
  const [orderBook, setOrderBook] = useState<any>(null);

  const loadOrders = () => {
    fetch("http://localhost:8080/orders")
      .then((res) => res.json())
      .then((data) => setOrderBook(data))
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    loadOrders();
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>ORDERBOOK</h1>

      <OrderForm onOrderSubmitted={loadOrders} />

      <h2>Buy Orders</h2>
      <ul>
        {orderBook?.buyOrders?.map((order: any) => (
          <li key={order.id}>
            {order.quantity} @ ${order.price}
          </li>
        ))}
      </ul>

      <h2>Sell Orders</h2>
      <ul>
        {orderBook?.sellOrders?.map((order: any) => (
          <li key={order.id}>
            {order.quantity} @ ${order.price}
          </li>
        ))}
      </ul>

      <h2>Trades</h2>
      <ul>
        {orderBook?.trades?.map((trade: any, index: number) => (
          <li key={index}>
            {trade.quantity} @ ${trade.price}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;