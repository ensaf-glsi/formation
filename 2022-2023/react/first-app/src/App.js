import './App.css';
import { useState } from 'react';
import { ProductList } from './features/product/List';
import EditProduct from './features/product/Edit';


export default function App() {
  const [list, setList] = useState(initiapProducts);
  const [id, setId] = useState(null);

  const seletedItem = list.find(p => p.id === id);

  function save(item) {
    if (seletedItem) {
      // update
      setList(list.map(p => p.id === seletedItem.id ? item : p));
    } else {
      // add
      setList([...list, {...item, id: list.length + 1}]);
    }
    setId(null);
  }

  function onEdit(productId) {
    setId(productId);
  }

  function onDelete(productId) {
    setList(list.filter(p => p.id !== productId))
  }
  return (
    <div className="container">
      <EditProduct key={id} onSave={save} product={seletedItem} />
      <ProductList products={list} onEdit={onEdit} onDelete={onDelete} />
    </div>
  );
}

const initiapProducts = [
  {
      "unit": 'U',
      "price": 30,
      "name": "Fantastic Cotton Salad",
      "id": 1
  },
  {
      "unit": 'KG',
      "price": 20,
      "name": "Intelligent Rubber Sausages",
      "id": 2
  },
  {
      "unit": 'U',
      "price": 60,
      "name": "Practical Soft Mouse",
      "id": 3
  },
  {
      "unit": 'L',
      "price": 10,
      "name": "Sleek Rubber Gloves",
      "id": 4
  }
]