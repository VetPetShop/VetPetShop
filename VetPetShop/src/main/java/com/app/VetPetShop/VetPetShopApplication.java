package com.app.VetPetShop;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.VetPetShop.DTO.CartItemsDto;
import com.app.VetPetShop.DTO.NewPetDto;
import com.app.VetPetShop.DTO.OrdersDto;
import com.app.VetPetShop.DTO.PaymentDto;
import com.app.VetPetShop.Pojos.CartItems;
import com.app.VetPetShop.Pojos.Orders;
import com.app.VetPetShop.Pojos.Payments;
import com.app.VetPetShop.Pojos.Pets;

@SpringBootApplication
@EnableAutoConfiguration
public class VetPetShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetPetShopApplication.class, args);
	}
	@Bean

	public WebMvcConfigurer configurer() { return new WebMvcConfigurer() {

@Override

public void addCorsMappings (CorsRegistry reg) { reg.addMapping("/**").allowedOrigins ("*");

}

};

	}
	@Bean
	public ModelMapper mapper()
	{
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		//custom mapping for associations
		mapper.createTypeMap(Pets.class, NewPetDto.class)
        .addMappings(mapr -> {
        	mapr.map(src -> src.getBreedId().getBreedName(), NewPetDto::setBreedName);
//            mapr.map(src -> src.getSellerId().getSellerId().getFirstName(), NewPetDto::setSellerFirstName);
//            mapr.map(src -> src.getSellerId().getSellerId().getLastName(), NewPetDto::setSellerLastName);
        });
		
		mapper.createTypeMap(CartItems.class, CartItemsDto.class).addMappings(mapr -> {
			mapr.map(src -> src.getCartId().getCartId(), CartItemsDto::setCartId);
			mapr.map(src -> src.getPetId().getPetId(), CartItemsDto::setPetId);
		});
		
		mapper.createTypeMap(Payments.class, PaymentDto.class).addMappings(mapr -> {
			mapr.map(src -> src.getUserId().getUserId(), PaymentDto::setUserId);
		});
		
		mapper.createTypeMap(Orders.class, OrdersDto.class).addMappings(mapr -> {
			mapr.map(src -> src.getTransactionId().getTransactionId(), OrdersDto::setTransactionId);
			mapr.map(src -> src.getItemId().getItemId(), OrdersDto::setItemId);
		});
		
		return mapper;
	}
	
	@Bean
    public UriComponents uriComponents() {
        return UriComponentsBuilder.newInstance().build();
    }

}
