package com.project._TShop.Services;


import com.project._TShop.DTO.ColorDTO;
import com.project._TShop.Entities.Color;
import com.project._TShop.Entities.User;
import com.project._TShop.Repositories.AccountRepository;
import com.project._TShop.Repositories.ColorRepository;
import com.project._TShop.Repositories.UserRepository;
import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorService {
    private final ColorRepository colorRepo;



    public Response getAllColor() {
        Response response = new Response();
        try {
            List<ColorDTO> allColorDTO = colorRepo.findAll().stream().map(Utils::mapColor).collect(Collectors.toList());
            response.setStatus(200);
            response.setColorDTOList(allColorDTO);
        }catch (Exception e){
            response.setStatus(500);
            response.setMessage("Error: Could not get all color. " + e.getMessage());
        }

        return response;
    }

    public Response addColor(ColorDTO colorDTO) {
        Response response = new Response();
       try{
           var color = Color.builder()
                   .name(colorDTO.getName())
                   .hex(colorDTO.getHex())
                   .build();
           colorRepo.save(color);
           response.setStatus(200);
           response.setMessage("message: Add new color success");
       }catch (Exception e){
           response.setStatus(500);
           response.setMessage("Error: Could not add new color. " + e.getMessage());
       }
        return response;

    }

    public Response updateColor(ColorDTO colorDTO) {
        Response response = new Response();
        try{
            Color color = colorRepo.findByColor_id(colorDTO.getColor_id());
            color.setName(colorDTO.getName());
            color.setHex(colorDTO.getHex());
            colorRepo.save(color);
            response.setStatus(200);
            response.setMessage("message: Add new color success");
        }catch (Exception e){
            response.setStatus(500);
            response.setMessage("Error: Could not update color. " + e.getMessage());
        }
        return response;
    }

    public Response deleteColor(String colorId) {
        Response response = new Response();
        try{
            colorRepo.delete(colorRepo.findByColor_id(Integer.parseInt(colorId)));
            response.setStatus(200);
            response.setMessage("message: delete color success");
        }catch (Exception e){
            response.setStatus(500);
            response.setMessage("Error: Could not update color. " + e.getMessage());
        }

        return response;
    }
}

