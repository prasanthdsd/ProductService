package com.project.productservice;

import com.project.productservice.inheritancerelations.singletable.*;
import com.project.productservice.models.Category;
import com.project.productservice.models.Order;
import com.project.productservice.models.Price;
import com.project.productservice.models.Product;
import com.project.productservice.repositories.CategoryRepository;
import com.project.productservice.repositories.OrderRepository;
import com.project.productservice.repositories.PriceRepository;
import com.project.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final ProductRepository productRepository;

    public ProductServiceApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
//    private final CategoryRepository categoryRepository;
//    private final ProductRepository productRepository;
//    private final PriceRepository priceRepository;
//    private final OrderRepository orderRepository;
//
//    public ProductServiceApplication(CategoryRepository categoryRepository, ProductRepository productRepository, PriceRepository priceRepository,
//                                     OrderRepository orderRepository) {
//        this.categoryRepository = categoryRepository;
//        this.productRepository = productRepository;
//        this.priceRepository = priceRepository;
//        this.orderRepository = orderRepository;
//    }

//    private MentorRepository mentorRepository;
//    private StudentRepository studentRepository;
//    private UserRepository userRepository;
//
//    ProductServiceApplication(@Qualifier("st_mentorrepository") MentorRepository mentorRepository, @Qualifier("st_studentrepository") StudentRepository studentRepository, @Qualifier("st_userrepository") UserRepository userRepository) {
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }

//    private MentorRepository mentorRepository;
//
//    private StudentRepository studentRepository;
//
//    private UserRepository userRepository;
//
//    ProductServiceApplication(@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository, StudentRepository studentRepository, UserRepository userRepository) {
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Mentor");
//        mentor.setEmail("mentor@gmail.com");
//        mentor.setAverageRating(4.8);
//
//        mentorRepository.save(mentor);

//        //tpc_mentor
//        Mentor mentor = new Mentor();
//        mentor.setName("Tpc_Mentor");
//        mentor.setEmail("tpc_mentor@gmail.com");
//        mentor.setAverageRating(4.5);
//
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Tpc_Student");
//        student.setEmail("tpc_student@gmail.com");
//        student.setPsp(85.2);
//
//        studentRepository.save(student);
//
//        User user = new User();
//        user.setName("Tpc_User");
//        user.setEmail("tpc_user@gmail.com");
//
//        userRepository.save(user);
//
//        userRepository.findAll().forEach(System.out::println);
//
//        User user = new User();
//        user.setName("Jack");
//        user.setEmail("jack@gmail.com");
//        userRepository.save(user);
//
//        Mentor mentor = new Mentor();
//        mentor.setName("mentor");
//        mentor.setEmail("mentor@gmail.com");
//        mentor.setAverageRating(70.2);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("student");
//        student.setEmail("student@gmail.com");
//        student.setPsp(56);
//        studentRepository.save(student);
//
//        Category category = new Category();
//        category.setName("Apple Devices");

//        Category savedCategory = categoryRepository.save(category);

//        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("e62816f6-3d5e-445f-8f09-d6d415f53e54"));
//
//        if (optionalCategory.isEmpty()) {
//            throw new RuntimeException("Category not found");
//        }


        //        Product product = new Product();
//        product.setName("Macbook Pro");
//        product.setDescription("New Launch Mac in apple");
//        product.setCategory(category.get());
//
//        Product savedProduct = productRepository.save(product);

        // Find all the products of the category "Apple devices
      //  optionalCategory.get().getProducts().forEach(product -> {System.out.println(product.getName());});
//        Price price = new Price();
//        price.setCurrency("INR");
//        price.setValue(BigDecimal.valueOf(120000));
//
//        Price savedPrice = priceRepository.save(price);
//
//        Category category = new Category();
//        category.setName("Apple Devices");
//        category.setDescription("Contains all the apple devices in the category");
//        Category savedCategory = categoryRepository.save(category);
//
//        Product product = new Product();
//        product.setCategory(savedCategory);
//        product.setName("IPhone 17 Pro");
//        product.setPrice(price);
//        product.setDescription("new product");
//
//        productRepository.save(product);

       // List<Product> products = productRepository.findAllByName("Iphone 17 Pro");

      //  productRepository.findAllByName_OrderById("IPhone 17 Pro").forEach(System.out::println);





    }
}
