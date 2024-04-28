package com.smartcare.ainutrition.assistant;

import com.smartcare.ainutrition.pantry.application.service.PantryService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/assistant")
@RequiredArgsConstructor
@RestController
public class AssistantController {
    private final OpenAiChatClient client;
    private final PantryService pantryService;

    @GetMapping
    public String getAssistance(@RequestParam(value = "message", defaultValue = "Me de sugestoes de receitas saudaveis") String message){
        PromptTemplate prompt = new PromptTemplate("""
                Responder apenas perguntas relacionadas a (nutricao, saude, alimetencao saudavel)
                Somente se a pergunta não for relacionada ao assunto, responder
                'Sou um assistente de nutrição. Apenas consigo lhe informar sobre alimentação e saúde.'
                
                {message}
                
                """);

        prompt.add("message", message);

        return client.call(prompt.create()).getResult().getOutput().getContent();
    }

    @GetMapping("/recipe")
    public String getAssistance(){
        String ingredients = pantryService.getPantryItems();
        PromptTemplate prompt = new PromptTemplate("""
                Com base na lista de receitas que irei lhe fornecer, me dê sugestoes de receitas saudáveis.
                {ingredients}
                """);

        prompt.add("ingredients", ingredients);

        return client.call(prompt.create()).getResult().getOutput().getContent();
    }
}
