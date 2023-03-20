import Navbar from "./components/Navbar";
import "./styles.css";
import './App.css';
import { Routes, Route } from "react-router-dom";
import Home from "./routes/Home";
import Cart from "./components/Cart"
import Auth from "./components/Auth";
import { Container } from "react-bootstrap";
import AboutUs from "./components/AboutUs";
import ContactUs from "./components/ContactUs";
import ShippingPolicy from "./components/ShippingPolicy";
import CancelationReturnPolicy from "./components/CancelationReturnPolicy";
import PrivacyPolicy from "./components/PrivacyPolicy";
import TermsAndCondition from "./components/TermsAndCondition"
import Login from "./AdminLogin";
import Category from "./Admin/pages/Category";
import Dashboard from './Admin/pages/Dashboard';
import AddProduct from './Admin/pages/AddProduct';
import UpdateProduct from './Admin/pages/UpdateProduct';
import AddCategory from './Admin/pages/AddCategory';

import AddSubcategory from './Admin/pages/AddSubcategory';
import AddTransporter from './Admin/pages/AddTransporter';
/* import Products from './Admin/pages/Products'; */
import Supports from './Admin/pages/Supports';
import UpdateTransporter from './Admin/pages/UpdateTransporter';




import MainLayout from "./Admin/Components/MainLayout";
function App() {
  return (
    <div className="App">
      <Container maxwidth="md">
     <Navbar/>
     <Routes>
   
            <Route path="/" element={<Home/>}/>
            <Route path="/cart" element={<Cart/>}></Route>
            <Route path="/login" element={<Auth/>}></Route>
            <Route path="/aboutus" element={<AboutUs/>}></Route>
            <Route path="/contactus" element={<ContactUs/>}></Route>
            <Route path="/shippingpolicy" element={<ShippingPolicy/>}></Route>
            <Route path="/cancelationreturnpolicy" element={<CancelationReturnPolicy/>}></Route>
            <Route path="/privacypolicy" element={<PrivacyPolicy/>}></Route>
            <Route path="/termsandcondition" element={<TermsAndCondition/>}></Route>
            <Route path="/adminLogin" element={<Login/>}></Route>
            <Route path="/admin" element={<MainLayout/>}>
            <Route path="/admin/categoryList" element={<Category/>}/>
        
           
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
          </Container>
    </div>
  );
}

export default App;
