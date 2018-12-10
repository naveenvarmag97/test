using Autofac;
using Autofac.Integration.WebApi;
using CRMS.Providers;
using log4net;
using Microsoft.Owin;
using Microsoft.Owin.Cors;
using Microsoft.Owin.Security;
using Microsoft.Owin.Security.DataHandler.Encoder;
using Microsoft.Owin.Security.Jwt;
using Microsoft.Owin.Security.OAuth;
using Owin;
using Repository;
using Repository.Interfaces;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Security.Cryptography;
using System.Web;
using System.Web.Http;

[assembly: OwinStartup(typeof(CRMS.Startup))]
namespace CRMS
{
    public class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            HttpConfiguration config = new HttpConfiguration();
            WebApiConfig.Register(config);

            log4net.Config.XmlConfigurator.Configure();

            app.UseCors(CorsOptions.AllowAll);

            //Configure OAuth
            ConfigureOAuth(app);

            ConfigureOAuthTokenConsumption(app);

            // DI using Autofac
            var builder = new ContainerBuilder();

            // Get your HttpConfiguration.
            //var config = GlobalConfiguration.Configuration;

            builder.RegisterType<Uow>().As<IUow>();

            // Register your Web API controllers.
            builder.RegisterApiControllers(Assembly.GetExecutingAssembly());
            builder.Register(c => LogManager.GetLogger("CRMSLogger")).As<ILog>(); // Log4Net Dependency Injection
            //builder.RegisterType<AccountController>().InstancePerRequest();

            // OPTIONAL: Register the Autofac filter provider.
            builder.RegisterWebApiFilterProvider(config);

            // OPTIONAL: Register the Autofac model binder provider.
            builder.RegisterWebApiModelBinderProvider();

            // Set the dependency resolver to be Autofac.
            var container = builder.Build();
            config.DependencyResolver = new AutofacWebApiDependencyResolver(container);

           // app.UseCors(CorsOptions.AllowAll);
            app.UseWebApi(config);

            AutoMapperConfig.Register();


            //var clientId = Guid.NewGuid().ToString("N");

            //var key = new byte[32];
            //RNGCryptoServiceProvider.Create().GetBytes(key);
            //var base64Secret = TextEncodings.Base64Url.Encode(key);

        }

        public void ConfigureOAuth(IAppBuilder app)
        {
            string issuer = ConfigurationManager.AppSettings["Issuer"];
            OAuthAuthorizationServerOptions OAuthServerOptions = new OAuthAuthorizationServerOptions()
            {
                AllowInsecureHttp = true,
                TokenEndpointPath = new PathString("/api/oauth/token"),
                AccessTokenExpireTimeSpan = TimeSpan.FromDays(1),
                Provider = new AuthorizationProvider(),
                AccessTokenFormat=new CustomJwtFormat(issuer)
            };

            // Token Generation
            app.UseOAuthAuthorizationServer(OAuthServerOptions);
            app.UseOAuthBearerAuthentication(new OAuthBearerAuthenticationOptions());

        }

        public void ConfigureOAuthTokenConsumption(IAppBuilder app)
        {
            var issuer = ConfigurationManager.AppSettings["Issuer"];
            string audienceId = ConfigurationManager.AppSettings["AudienceId"];
            byte[] audienceSecret = TextEncodings.Base64Url.Decode(ConfigurationManager.AppSettings["AudienceSecret"]);

            // Api controllers with an [Authorize] attribute will be validated with JWT
            app.UseJwtBearerAuthentication(
                new JwtBearerAuthenticationOptions
                {
                    AuthenticationMode = AuthenticationMode.Active,
                    AllowedAudiences = new[] { audienceId },
                    IssuerSecurityTokenProviders = new IIssuerSecurityTokenProvider[]
                    {
                        new SymmetricKeyIssuerSecurityTokenProvider(issuer, audienceSecret)
                    }
                });
        }
    }
}