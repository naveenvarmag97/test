using Data;
using Data.Entity;
using Microsoft.Owin.Security;
using Microsoft.Owin.Security.OAuth;
using Repository;
using Repository.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using System.Web;

namespace CRMS.Providers
{
    public class AuthorizationProvider : OAuthAuthorizationServerProvider
    {
        private IUow _uow;
        public AuthorizationProvider()
        {
            _uow = new Uow();
        }

        public override Task ValidateClientAuthentication(OAuthValidateClientAuthenticationContext context)
        {
            context.Validated();
            return Task.FromResult<object>(null);
        }

        public override async Task GrantResourceOwnerCredentials(OAuthGrantResourceOwnerCredentialsContext context)
        {
            //context.OwinContext.Response.Headers.Add("Access-Control-Allow-Origin", new[] { "*" });
            //context.OwinContext.Response.Headers.Add("Access-Control-Allow-Methods", new[] { "GET, PUT, DELETE, POST, OPTIONS" });
            //context.OwinContext.Response.Headers.Add("Access-Control-Allow-Headers", new[] { "Content-Type, Accept, Authorization" });
            //context.OwinContext.Response.Headers.Add("Access-Control-Max-Age", new[] { "1728000" });

            User user = await _uow.AuthRepository.FindUser(context.UserName, context.Password);

            if (user == null)
            {
                context.SetError("invalid_grant", "The user name or password is incorrect.");
                return;
            }
            var identity = new ClaimsIdentity(context.Options.AuthenticationType);
            identity.AddClaim(new Claim(ClaimTypes.Role,((byte)user.UserType).ToString()));
            identity.AddClaim(new Claim("empid", user.EmpID.ToString()));
            identity.AddClaim(new Claim(ClaimTypes.Email, user.Email.ToString()));
            identity.AddClaim(new Claim("userid", user.Id.ToString()));
            identity.AddClaim(new Claim(ClaimTypes.Name, user.Firstname+" "+user.Lastname));


            //identity.AddClaim(new Claim("firstname", user.Firstname));
            //identity.AddClaim(new Claim("lastname", user.Lastname));



            var ticket = new AuthenticationTicket(identity, null);

            context.Validated(ticket);
        }

       
    }
}