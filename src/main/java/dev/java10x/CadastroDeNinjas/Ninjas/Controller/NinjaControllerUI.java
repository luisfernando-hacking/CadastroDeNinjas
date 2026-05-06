package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import dev.java10x.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.java10x.CadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "html/listarNinjas";
    }

    @GetMapping("/listar/{id}")
    public String listarNinjaPorId(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "html/detalhesNinja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "redirect:/ninjas/ui/listar";
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "html/adicionarNinja";
    }

    @PostMapping("/criar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja) {
        ninjaService.criarNinja(ninja);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "html/editarNinja";
        } else {
            return "redirect:/ninjas/ui/listar";
        }
    }

    @PostMapping("/editar/{id}")
    public String atualizarNinja(@PathVariable Long id, @ModelAttribute NinjaDTO ninjaAtualizado) {
        ninjaService.atualizarNinjaPorId(id, ninjaAtualizado);
        return "redirect:/ninjas/ui/listar";
    }

}