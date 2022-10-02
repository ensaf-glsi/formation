export function ProductList({ products, onEdit, onDelete }) {
    function handleDelete(id) {
        if (window.confirm('Etes vous sur de vouloir supprimer cette ligne ?')) {
            onDelete(id);
        }
    }
    const rows = products.map(product => (
        <tr key={product.id}>
            <td>{product.id}</td>
            <td>{product.name}</td>
            <td>{product.price}</td>
            <td>{product.unit}</td>
            <td>
                <button className="btn btn-secondary" onClick={() => onEdit(product.id)}>Edit</button>
                {' '}
                <button className="btn btn-danger" onClick={() => handleDelete(product.id)}>Delete</button>
            </td>
        </tr>
    ));

    return (
        <div>
            <h2>Product List</h2>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Unit</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {rows}
                </tbody>
            </table>
        </div>
    );
}