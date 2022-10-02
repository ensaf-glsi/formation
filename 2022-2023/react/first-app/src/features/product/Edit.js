import { useForm } from "react-hook-form";

const units = ['KG', 'L', 'U', 'M'];

export default function EditProduct({ onSave, product }) {
    const { register, handleSubmit, reset } = useForm({
        defaultValues: product
    });
    const onSubmit = d => {
        onSave(d);
    }
    return (
        <form onSubmit={handleSubmit(onSubmit)} onReset={() => reset(product)}>
            <h2>{product ? 'Update Product' : 'Add Product'}</h2>
            <div className="row mb-3">
                <label htmlFor="name" className="col-sm-2 col-form-label">
                    Name
                </label>
                <div className="col-sm-10">
                    <input type="text" className="form-control" id="name" {...register('name')} />
                </div>
            </div>
            <div className="row mb-3">
                <label htmlFor="price" className="col-sm-2 col-form-label">
                    Price
                </label>
                <div className="col-sm-10">
                    <input type="number" className="form-control" id="price" {...register('price')} />
                </div>
            </div>
            <div className="row mb-3">
                <label htmlFor="unit" className="col-sm-2 col-form-label">
                    Unit
                </label>
                <div className="col-sm-10">
                    <select id="unit" className="form-select" {...register('unit')}>
                        <option></option>
                        {units.map(unit => (<option key={unit}>{unit}</option>))}
                    </select>
                </div>
            </div>
            <button type="reset" className="btn btn-secondary">
                Cancel
            </button>
            {' '}
            <button type="submit" className="btn btn-primary">
                Validate
            </button>
        </form>
    );
}