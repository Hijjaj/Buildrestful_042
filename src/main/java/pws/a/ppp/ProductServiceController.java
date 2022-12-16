/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.a.ppp;

import java.util.HashMap;
import java.util.Map;
import model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@RestController
public class ProductServiceController {
    //membuat hashmap untuk menyimpan data
   private static Map<String, Product> productRepo = new HashMap<>();
   static 
   {
       //deklarasi isi hashmap
      Product honey = new Product();
      //memberikan id
      honey.setId("1");
      //memberikan nama
      honey.setName("Honey");
      //memberikan harga
      honey.setPrice(10000);
      //meberikan diskon
      honey.setDiskon(0.01);
      //memberikan total
      honey.setTotal();
      //menaruh berdasarkan id
      productRepo.put(honey.getId(), honey);
      //deklarasi isi hashmap
      Product almond = new Product();
      //memberikan id
      almond.setId("2");
      //memberikan nama
      almond.setName("Almond");
      //memberikan harga
      almond.setPrice(15000);
      //memberikan diskon
      almond.setDiskon(0.02);
      //memberikan total
      almond.setTotal();
      //menaruh berdasarkan id
      productRepo.put(almond.getId(), almond);
   }
   //membuat method delete data
   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   //melakukan pengaturan untuk delete berdasarkan id
   public ResponseEntity<Object> delete(@PathVariable("id") String id) 
   { 
      //delete isi 
      productRepo.remove(id);
      //tampilkan pesan dan status
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }
   //membuat method edit data
   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
   //melakukan pengaturan untuk edit berdasarkan id
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) 
   {
      //jika id yang diedit belum ada maka tampilkan pesan error
      if(!productRepo.containsKey(id))
      { 
        //tampilkan pesan dan status  
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
      }
      //jika id sudah ada maka edit data tersebut dan tampilkan pesan sukses dan status
      else
      {
          //hapus berdasarkan id
        productRepo.remove(id);
        //memberikan id
        product.setId(id);
        //menaruh id
        productRepo.put(id, product);
        //menampilkan pesan dan status
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
      }
   }
   //membuat method buat data
   @RequestMapping(value = "/products", method = RequestMethod.POST)
   //melakukan pengaturan membuat data
   public ResponseEntity<Object> createProduct(@RequestBody Product product) 
   {
      //jika id data yang dibuat sudah ada sebelumnya, maka tampilkan pesan error
      if (productRepo.containsKey(product.getId()))
      {
          //tampilkan pesan dan status
        return new ResponseEntity<>("Cannot add same id", HttpStatus.OK);
      }
      //jika id belum ada maka tampilkan pesan sukses dan buat data
      else
      {
          //dapatkan id
        productRepo.put(product.getId(), product);
        //tampilkan pesan dan status
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
      }
   }
   //membuat jalan 
   @RequestMapping(value = "/products")
   //mengimport Product
   public ResponseEntity<Object> getProduct() 
   {
       //tampilkan status
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }
}
