
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SkeletonComponent } from './layouts/skeleton/skeleton.component';

const routes: Routes = [
  {
    path: 'auth',
    loadChildren: () =>
    import('./pages/auth/auth.module').then((m) => m.AuthModule),
  },
  {
    path: '',
    component: SkeletonComponent,
    children: [
      {
        path: 'home',
        loadChildren: () =>
          import('./pages/main/main.module').then((m) => m.MainModule),
      },
      {
        path: 'account',
        loadChildren: () =>
          import('./pages/account/account.module').then((m) => m.AccountModule),
      },
      {
        path: 'checkout',
        loadChildren: () =>
          import('./pages/checkout/checkout.module').then((m) => m.CheckoutModule),
      },
      {
        path: 'descripcion',
        loadChildren: () =>
          import('./pages/descripcion-producto/descripcion.module').then((m) => m.DescripcionModule),
      },
      {
        path: 'productos',
        loadChildren: () =>
          import('./pages/productos/productos.module').then((m) => m.ProductosModule),
      },
      {
        path: 'nosotros',
        loadChildren: () =>
          import('./pages/nosotros/nosotros.module').then((m) => m.NosotrosModule),
      },
      { path: '**', redirectTo: '/home', pathMatch: 'full' },
    ],
  },
  { path: '**', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
