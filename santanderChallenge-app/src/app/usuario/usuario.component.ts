import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { UsuarioService } from './usuario.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html'
})

export class UsuarioComponent implements OnInit {

  public usuarios: Usuario[];

  constructor(public usuariosService: UsuarioService) { }

  ngOnInit() {
      this.usuariosService.getUsuarios().subscribe(
        usuarios => this.usuarios = usuarios
      );
  }
  
}
