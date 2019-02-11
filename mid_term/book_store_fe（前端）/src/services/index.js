import request from './request';
import { async } from 'rxjs/internal/scheduler/async';
const baseUrl = 'http://localhost:8080/';
const makeUrl = val => `${baseUrl + val}`;

// user

export async function login(params) {
  return request(`${makeUrl('user/login')}`, {
    method: 'POST',
    body: params,
  });
}
export async function register(params) {
  return request(`${makeUrl('user/register')}`, {
    method: 'POST',
    body: params,
  });
}

export async function getAllUser(){
  return request(`${makeUrl('user/allUser')}`)
}

//  book
export async function getChoiceBook() {
  return request(`${makeUrl('book/choice')}`);
}

export async function getAllBooks() {
  return request(`${makeUrl('book/all')}`);
}
export async function getBookByPage(page) {
  return request(`${makeUrl(`book/pageAll?page=${page}&size=10`)}`);
}
export async function getBookById(id) {
  return request(`${makeUrl(`book/bookById?id=${id}`)}`);
}

// shopping cart
export async function addToCart(data) {
  return request(`${makeUrl(`shopping/add?bookId=${data}`)}`);
}
export async function getCart() {
  return request(`${makeUrl('shopping/getall')}`);
}
export async function modifyCart(data) {
  return request(`${makeUrl('shopping/modify')}`, {
    method: 'POST',
    body: data,
  });
}
export async function deleteCart(id) {
  return request(`${makeUrl(`shopping/delete?id=${id}`)}`);
}

//  orders
export async function submitOrder(data) {
  return request(`${makeUrl(`order/add`)}`, {
    method: 'POST',
    body: data,
  });
}
export async function getOrder() {
  return request(`${makeUrl('order/queryAllByUserId')}`);
}

export async function getAllOrders() {
  return request(`${makeUrl('order/queryAll')}`);
}

export async function modifyOrder(state,id) {
  return request(`${makeUrl(`order/updateStatus?state=${state}&id=${id}`)}`);
}
