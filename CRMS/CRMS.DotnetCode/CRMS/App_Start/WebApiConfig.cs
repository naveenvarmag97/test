using CRMS.Filters;
using Elmah.Contrib.WebApi;
using Newtonsoft.Json.Serialization;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Formatting;
using System.Web.Http;
using System.Web.Http.Cors;
using System.Web.Http.ExceptionHandling;

namespace CRMS
{
    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            // Web API configuration and services

            // Web API routes
            config.MapHttpAttributeRoutes();

            //config.Routes.MapHttpRoute(
            //    name: "DefaultApi",
            //    routeTemplate: "api/{controller}/{id}",
            //    defaults: new { id = RouteParameter.Optional }
            //);

            config.Routes.MapHttpRoute(
                   name: "API Default",
                   routeTemplate: "api/{controller}/{action}/{id}",
                   defaults: new { id = RouteParameter.Optional });

            //config.EnableCors(new EnableCorsAttribute("*", "*", "GET, POST, OPTIONS, PUT, DELETE"));

            config.Services.Add(typeof(IExceptionLogger), new ElmahExceptionLogger()); // ELMAH Exception Handling

            config.Filters.Add(new ModelStateValidator());
            //config.Filters.Add(new AuthorizeAttribute());

            //config.Filters.Add(new ExceptionFilter());



            var appXmlType = config.Formatters.XmlFormatter.SupportedMediaTypes.FirstOrDefault(t => t.MediaType == "application/xml");
            config.Formatters.XmlFormatter.SupportedMediaTypes.Remove(appXmlType);

            config.Formatters.JsonFormatter.SerializerSettings.ContractResolver = new CamelCasePropertyNamesContractResolver();
            config.Formatters.JsonFormatter.UseDataContractJsonSerializer = false;
        }
    }
}
