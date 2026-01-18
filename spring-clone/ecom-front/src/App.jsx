import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import Products from "./compoents/Products";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <Products />
    </>
  );
}

export default App;
