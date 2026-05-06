package dev.java10x.CadastroDeNinjas.Missoes.Controller;

import dev.java10x.CadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.Service.MissoesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUI {

    private final MissoesService missoesService;

    public MissoesControllerUI(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model) {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "html/listarMissoes";
    }

    @GetMapping("/listar/{id}")
    public String listarMissaoPorId(@PathVariable Long id, Model model) {
        MissoesDTO missao = missoesService.listarMissaoPorId(id);

        if (missao != null) {
            model.addAttribute("missao", missao);
            return "html/detalhesMissao";
        } else {
            return "redirect:/missoes/ui/listar";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionar(Model model) {
        model.addAttribute("missao", new MissoesDTO());
        return "html/adicionarMissao";
    }

    @PostMapping("/criar")
    public String salvarMissao(@ModelAttribute MissoesDTO missao) {
        missoesService.adicionarMissao(missao);
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        MissoesDTO missao = missoesService.listarMissaoPorId(id);

        if (missao != null) {
            model.addAttribute("missao", missao);
            return "html/editarMissao";
        } else {
            return "redirect:/missoes/ui/listar";
        }
    }

    @PostMapping("/editar/{id}")
    public String atualizarMissao(@PathVariable Long id,
                                  @ModelAttribute MissoesDTO missaoAtualizada) {
        missoesService.editarMissaoPorId(id, missaoAtualizada);
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissaoporId(id);
        return "redirect:/missoes/ui/listar";
    }
}