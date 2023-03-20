
import './App.css';
import { BrowserRouter as Router,Routes,Route } from 'react-router-dom';
import MainLayout from './Admin/Components/MainLayout';
import Dashboard from './Admin/pages/Dashboard';
import AddProduct from './Admin/pages/AddProduct';
import UpdateProduct from './Admin/pages/UpdateProduct';
import AddCategory from './Admin/pages/AddCategory';
import Category from './Admin/pages/Category';
import AddSubcategory from './Admin/pages/AddSubcategory';
import AddTransporter from './Admin/pages/AddTransporter';
/* import Products from './Admin/pages/Products'; */
import Supports from './Admin/pages/Supports';
import UpdateTransporter from './Admin/pages/UpdateTransporter';



function AdminHome() {
  return (
    <Router>
      <Routes>
        <Route path="/admin" element={<MainLayout/>}>
        <Route index element={<Dashboard/>}/>
         <Route path="/admin/add-product" element={<AddProduct/>}/> 
       {/* <Route path="/admin/productList" element={<Products/>}/> */}
        <Route path="/admin/addproducts" element={<AddProduct></AddProduct>}/>
         <Route path="/admin/updateproduct" element={<UpdateProduct/>}/>
       {/*  <Route path="/admin/categoryList" element={<Category/>}/> */}
         <Route path="/admin/addcategory" element={<AddCategory/>}/>
  <Route path="/admin/addsubcategory" element={<AddSubcategory/>}/>
                {/*   <Route path="/admin/transporter" element={<Transporter/>}/> */}
         <Route path="/admin/transporters/:transporterId" element={<UpdateTransporter/>}/>
         <Route path="/admin/addtransporters" element={<AddTransporter/>}/>
         {/* <Route path="/admin/subcategoryList" element={<Subcategory/>}/> */}
		     <Route path="/admin/support" element={<Supports/>}> 
        
         </Route>
        </Route>
      </Routes>
    </Router>
  );
}

export default AdminHome;
