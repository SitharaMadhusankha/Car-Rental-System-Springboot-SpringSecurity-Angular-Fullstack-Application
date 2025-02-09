import { Component } from '@angular/core';
import { Signup } from 'src/app/dto/signup';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
  signup:Signup={
    username:'sithara',
    userFirstName:'',
    userLastName:'',
    userPassword:'',
    userRole:'user'
  }

  register(){

  }
}
