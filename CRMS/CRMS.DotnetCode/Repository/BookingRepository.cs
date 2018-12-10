using Data;
using Data.Entity;
using Repository.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace Repository
{
    public class BookingRepository : GenericRepository<Booking>, IBookingRepository
    {
        public BookingRepository(CRMSDbContext dbContext) : base(dbContext)
        {
        }

        public async Task SaveBooking(Booking booking)
        {
            if (await IsRoomAvailable(booking))
            {
                // Room is availble, now we can proceed with booking
                Save(booking);
            }
            else
            {
                throw new Exception("Selected room is not available!!!!");
            }
        }

        private async Task<bool> IsRoomAvailable(Booking booking)
        {
            var secondsTimespan = new TimeSpan(0, 0, 1);
            var StartDateTs = booking.StartDateTs.Add(secondsTimespan);

            var CurrentBookinsOnStartDate = await Get(filter: d => d.RoomId == booking.RoomId && !d.IsCancelled && 
            ((d.StartDateTs <= StartDateTs || d.StartDateTs <= booking.EndDateTs) 
            && (d.EndDateTs >= StartDateTs || d.EndDateTs >= booking.EndDateTs)));

            if (CurrentBookinsOnStartDate.Count() == 0) // No bookings on that selected date
                return true;

            return CurrentBookinsOnStartDate.Count() == 0;
        }

        //private async Task<bool> ValidateBooking(Booking booking)
        //{
        //    if(booking.StartDateTs > booking.EndDateTs)
        //        throw new Exception()
        //}
    }
}
