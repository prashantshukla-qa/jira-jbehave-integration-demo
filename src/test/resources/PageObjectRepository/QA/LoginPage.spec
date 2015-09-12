Page Title: SAM - Log In

#Object Definitions
====================================================================================

inp_username    css #username
inp_password    css #password
btn_login       css #login
txt_error   css #error
====================================================================================

@all, browsers
--------------------------------
inp_password
    below: inp_username 10 px
    hover: css 

@all
--------------------------------
inp_password
    above: inp_username 10 px

@browser
--------------------------------
inp_password
    below: inp_username > 10 px