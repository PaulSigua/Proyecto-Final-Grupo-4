import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/models/Cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-account-info',
  templateUrl: './account-info.component.html',
  styleUrls: ['./account-info.component.scss']
})
export class AccountInfoComponent implements OnInit {

  string = '';

  cliente: any;
  informacionCliente : any;

  constructor(private router: Router, private clienteService: ClienteService) {
  }

  ngOnInit(): void {
    this.verificarInformacionLocalStorage();
  }

  public actualizarCliente(){
    this.clienteService.actualizarCliente(this.cliente).subscribe(data => {
      console.log(data);
      alert('Se actualizo con exito');
      localStorage.setItem('cliente', JSON.stringify(data));
      this.ngOnInit();
    });
  }

  verificarInformacionLocalStorage() {
    const informacion = localStorage.getItem('cliente');
    if(informacion){
      this.informacionCliente = JSON.parse(informacion);
      this.cliente = this.informacionCliente.cliente;
      this.string = this.informacionCliente.cliente.primerNombre;
    }
  }

  public cerrarSesion(){
    localStorage.removeItem('cliente');
    localStorage.removeItem('carrito');
    this.router.navigate(['/home']);
  }

}
