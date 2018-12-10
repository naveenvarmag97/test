using AutoMapper;
using Data.Entity;
using Data.ViewModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CRMS
{
    public static class AutoMapperConfig
    {

        /// <summary>
        /// Register Automapper Configurations
        /// </summary>
        public static void Register()
        {
            Mapper.Initialize(Configurations);
        }

        public static void Configurations(IMapperConfigurationExpression config)
        {
            config.CreateMap<Booking, BookingViewModel>()
                .ForMember(dest => dest.BookedBy, opt => opt.MapFrom(src => src.Employee.Firstname+" "+src.Employee.Lastname ))
                .ForMember(dest => dest.RoomName, opt => opt.MapFrom(src => src.ConfreneceRoom.Name))
                .ForMember(dest => dest.RoomLocation, opt => opt.MapFrom(src => src.ConfreneceRoom.Location))
                .ForMember(dest => dest.CancelledOnTs, opt => opt.MapFrom(src => src.ModifiedTs));


            config.CreateMap<ConfreneceRoom, LookupViewModel>()
               .ForMember(dest => dest.Value, opt => opt.MapFrom(src => GetRoomLookupValue(src)))
               .ForMember(dest => dest.Key, opt => opt.MapFrom(src =>src.Id));
        }

        private static string GetRoomLookupValue(ConfreneceRoom oConfreneceRoom)
        {
            return string.Format("{0} - {1}", oConfreneceRoom.Location, oConfreneceRoom.Name);
        }
    }
}