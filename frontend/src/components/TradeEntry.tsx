import { useState } from "react";

type TradeEntryProps = {
  onOrderSubmitted: () => void;
};

function TradeEntry({ onOrderSubmitted }: TradeEntryProps) {
  const [side, setSide] = useState("BUY");
  const [price, setPrice] = useState("");
  const [quantity, setQuantity] = useState("");

  const submitOrder = async () => {
    const order = {
      id: crypto.randomUUID(),
      side,
      price: Number(price),
      quantity: Number(quantity)
    };

    try {
      const response = await fetch("http://localhost:8080/orders", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(order)
      });

      if (!response.ok) {
        throw new Error("Failed to submit order");
      }

      onOrderSubmitted();

      setPrice("");
      setQuantity("");
    } catch (error) {
      console.error(error);
      alert("Failed to submit order");
    }
  };

  return (
    <div>
      <h2>Submit Order</h2>

      <select
        value={side}
        onChange={(e) => setSide(e.target.value)}
      >
        <option value="BUY">BUY</option>
        <option value="SELL">SELL</option>
      </select>

      <br />
      <br />

      <input
        type="number"
        placeholder="Price"
        value={price}
        onChange={(e) => setPrice(e.target.value)}
      />

      <br />
      <br />

      <input
        type="number"
        placeholder="Quantity"
        value={quantity}
        onChange={(e) => setQuantity(e.target.value)}
      />

      <br />
      <br />

      <button onClick={submitOrder}>
        Submit Order
      </button>
    </div>
  );
}

export default TradeEntry;